package com.pjomtech.dotaretriever.feign;

import com.pjomtech.dotaretriever.model.ParsedMatch;
import com.pjomtech.dotaretriever.model.PublicMatch;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "parsedMatch", url = "https://api.opendota.com/api/parsedMatches")
public interface ParsedMatchClient {
    @GetMapping
    List<ParsedMatch> getParsedMatches();
}
