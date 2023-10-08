package com.pjomtech.dotaretriever.feign;

import com.pjomtech.dotaretriever.dto.MatchDetailsDTO;
import com.pjomtech.dotaretriever.model.MatchDetails;
import com.pjomtech.dotaretriever.model.PublicMatch;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "matchdetails", url = "https://api.opendota.com/api/matches")
public interface MatchDetailsClient {
    @GetMapping("/{matchId}/")
    MatchDetailsDTO getMatchDetails(@PathVariable("matchId") Long matchId);
}
