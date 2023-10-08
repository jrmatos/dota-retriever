package com.pjomtech.dotaretriever.service;

import com.pjomtech.dotaretriever.dto.MatchDetailsDTO;
import com.pjomtech.dotaretriever.dto.MatchDetailsPlayerDTO;
import com.pjomtech.dotaretriever.feign.MatchDetailsClient;
import com.pjomtech.dotaretriever.feign.PublicMatchClient;
import com.pjomtech.dotaretriever.model.MatchDetails;
import com.pjomtech.dotaretriever.model.ParsedMatch;
import com.pjomtech.dotaretriever.model.PublicMatch;
import com.pjomtech.dotaretriever.repository.ParsedMatchRepository;
import com.pjomtech.dotaretriever.repository.PublicMatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnalyzerService {
    private final ParsedMatchRepository parsedMatchRepository;
    private final MatchDetailsClient matchDetailsClient;


    @Scheduled(fixedDelay = 2 * 1000) // every second
    public void collector() {
        Optional<ParsedMatch> uncheckedParsedMatchOptional = parsedMatchRepository.findFirstByChecked(false);

        if (uncheckedParsedMatchOptional.isPresent()) {
            ParsedMatch uncheckedParsedMatch = uncheckedParsedMatchOptional.get();
            MatchDetailsDTO matchDetails = matchDetailsClient.getMatchDetails(uncheckedParsedMatch.getMatchId());

            System.out.println(uncheckedParsedMatch);

            if (matchDetails.getRankTier() != null && matchDetails.getRankTier() < 70) return; // less than Ancient

            List<MatchDetailsPlayerDTO> list = matchDetails
                    .getPlayers()
                    .stream()
                    .filter(player -> player.getMultiKills().containsKey("5"))
                    .toList();

            if (!list.isEmpty()) {
                System.out.println(list);
            }

            uncheckedParsedMatch.setChecked(true);
            parsedMatchRepository.save(uncheckedParsedMatch);
        }
    }
}
