package com.pjomtech.dotaretriever.service;

import com.pjomtech.dotaretriever.feign.PublicMatchClient;
import com.pjomtech.dotaretriever.model.PublicMatch;
import com.pjomtech.dotaretriever.repository.PublicMatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PublicMatchService {
    private final PublicMatchClient publicMatchClient;
    private final PublicMatchRepository publicMatchRepository;

    public void getPublicMatches() {
        List<PublicMatch> publicMatches = publicMatchClient.getPublicMatches();
        publicMatches.stream().forEach(publicMatch -> {
            Optional<PublicMatch> match = publicMatchRepository.findById(publicMatch.getMatchId());

            if (match.isEmpty()) {
                publicMatchRepository.save(publicMatch);
            }
        });
    }
}
