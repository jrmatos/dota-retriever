package com.pjomtech.dotaretriever.service;

import com.pjomtech.dotaretriever.dto.MatchDetailsDTO;
import com.pjomtech.dotaretriever.dto.MatchDetailsPlayerDTO;
import com.pjomtech.dotaretriever.feign.MatchDetailsClient;
import com.pjomtech.dotaretriever.feign.PublicMatchClient;
import com.pjomtech.dotaretriever.model.*;
import com.pjomtech.dotaretriever.repository.ParsedMatchRepository;
import com.pjomtech.dotaretriever.repository.PublicMatchRepository;
import com.pjomtech.dotaretriever.repository.RampageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AnalyzerService {
    private final ParsedMatchRepository parsedMatchRepository;
    private final RampageRepository rampageRepository;
    private final MatchDetailsClient matchDetailsClient;
    private final HeroService heroService;


    @Scheduled(fixedDelay = 2 * 1000) // every 2 seconds
    public void collector() {
        log.info("Running collector...");
        Optional<ParsedMatch> uncheckedParsedMatchOptional = parsedMatchRepository.findFirstByChecked(false);

        if (uncheckedParsedMatchOptional.isPresent()) {
            ParsedMatch uncheckedParsedMatch = uncheckedParsedMatchOptional.get();

            log.info("Fetching match details of unchecked parsed match -> " + uncheckedParsedMatch.getMatchId());

            MatchDetailsDTO matchDetails = matchDetailsClient.getMatchDetails(uncheckedParsedMatch.getMatchId());

            log.info("Fetch finished");

            if (matchDetails.getRankTier() != null && matchDetails.getRankTier() < 70) {
                log.info("Rank is too low. Aborting.");
                return; // discard matches less than Ancient
            }

            log.info("Running checkers...");
            runCheckers(matchDetails);

            uncheckedParsedMatch.setChecked(true);
            parsedMatchRepository.save(uncheckedParsedMatch);
        }
    }

    private void runCheckers(MatchDetailsDTO matchDetails) {
        lookForRampage(matchDetails);
    }

    private void lookForRampage(MatchDetailsDTO matchDetails) {
        log.info("Looking for rampages in the match...");
        List<MatchDetailsPlayerDTO> playersWithRampage = matchDetails
                .getPlayers()
                .stream()
                .filter(player -> player.getMultiKills().containsKey("5"))
                .toList();

        if (playersWithRampage.isEmpty()) {
            log.info("No rampages found in the match...");
            return;
        }

        log.info("Found " + playersWithRampage.size() + " players with rampages!");
        log.info("Match -> " + matchDetails.getMatchId());

        playersWithRampage.stream().forEach(player -> {
            Hero hero = heroService.findById(player.getHeroId());

            Rampage rampage = new Rampage();
            rampage.setMatchId(matchDetails.getMatchId());
            rampage.setHero(hero);
            rampage.setStartTime(matchDetails.getStartTime());
            rampage.setActionStart(0);
            rampage.setRankTier(matchDetails.getRankTier());
            rampage.setReplayUrl(matchDetails.getReplayUrl());

            rampageRepository.save(rampage);
            log.info("Rampage saved!");
        });

        log.info("All rampages saved!");
    }
}
