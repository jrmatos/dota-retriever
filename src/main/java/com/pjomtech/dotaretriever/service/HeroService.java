package com.pjomtech.dotaretriever.service;

import com.pjomtech.dotaretriever.feign.HeroesClient;
import com.pjomtech.dotaretriever.model.Hero;
import com.pjomtech.dotaretriever.repository.HeroRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HeroService {
    private final HeroesClient heroesClient;
    private final HeroRepository heroRepository;

    public void populateHeroes() {
        List<Hero> heroes = heroesClient.getHeroes();
        heroRepository.saveAll(heroes);
    }



}
