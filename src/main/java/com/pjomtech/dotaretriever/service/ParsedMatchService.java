package com.pjomtech.dotaretriever.service;

import com.pjomtech.dotaretriever.feign.ParsedMatchClient;
import com.pjomtech.dotaretriever.feign.PublicMatchClient;
import com.pjomtech.dotaretriever.model.ParsedMatch;
import com.pjomtech.dotaretriever.model.PublicMatch;
import com.pjomtech.dotaretriever.repository.ParsedMatchRepository;
import com.pjomtech.dotaretriever.repository.PublicMatchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ParsedMatchService {
    private final ParsedMatchClient parsedMatchClient;
    private final ParsedMatchRepository parsedMatchRepository;

    // runs every 1 minute
    @Scheduled(fixedDelay = 60 * 1000)
    public void getParsedMatches() {
        Integer savedCounter = 0;
        log.info("Getting parsed matches...");
        List<ParsedMatch> parsedMatches = parsedMatchClient.getParsedMatches();

        log.info("Retrieved " + parsedMatches.size() + " parsed matches...");



        parsedMatches.stream().forEach(parsedMatch -> {
            Optional<ParsedMatch> match = parsedMatchRepository.findById(parsedMatch.getMatchId());

            if (match.isEmpty()) {
                log.info("Match " + parsedMatch.getMatchId() + " does not exist. Saving...");

                parsedMatch.setChecked(false);
                parsedMatchRepository.save(parsedMatch);
            }
        });

        log.info("Amount of new parsed matches saved -> " + savedCounter);
    }
}
