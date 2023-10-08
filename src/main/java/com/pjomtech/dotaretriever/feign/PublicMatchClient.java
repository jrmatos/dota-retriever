package com.pjomtech.dotaretriever.feign;

import com.pjomtech.dotaretriever.model.PublicMatch;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "publicMatch", url = "https://api.opendota.com/api/publicMatches")
public interface PublicMatchClient {
    @GetMapping
    List<PublicMatch> getPublicMatches();
}
