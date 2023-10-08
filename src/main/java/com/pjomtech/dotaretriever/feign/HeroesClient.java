package com.pjomtech.dotaretriever.feign;

import com.pjomtech.dotaretriever.model.Hero;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "heroes", url = "https://api.opendota.com/api/heroes")
public interface HeroesClient {
    @GetMapping
    List<Hero> getHeroes();
}
