package com.pjomtech.dotaretriever.service;

import com.pjomtech.dotaretriever.feign.ParsedMatchClient;
import com.pjomtech.dotaretriever.feign.PublicMatchClient;
import com.pjomtech.dotaretriever.model.ParsedMatch;
import com.pjomtech.dotaretriever.model.PublicMatch;
import com.pjomtech.dotaretriever.repository.ParsedMatchRepository;
import com.pjomtech.dotaretriever.repository.PublicMatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParsedMatchService {
    private final ParsedMatchClient parsedMatchClient;
    private final ParsedMatchRepository parsedMatchRepository;

    // runs every 1 minute
    @Scheduled(fixedDelay = 60 * 1000)
    public void getParsedMatches() {
        List<ParsedMatch> parsedMatches = parsedMatchClient.getParsedMatches();
        parsedMatches.stream().forEach(parsedMatch -> {
            Optional<ParsedMatch> match = parsedMatchRepository.findById(parsedMatch.getMatchId());

            if (match.isEmpty()) {
                parsedMatch.setChecked(false);
                parsedMatchRepository.save(parsedMatch);
            }
        });
    }
}
