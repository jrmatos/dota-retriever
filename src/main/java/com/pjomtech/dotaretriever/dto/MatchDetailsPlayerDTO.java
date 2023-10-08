package com.pjomtech.dotaretriever.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class MatchDetailsPlayerDTO {
    @JsonProperty("player_slot")
    private Integer playerSlot;

    @JsonProperty("multi_kills")
    private Map<String, String> multiKills;
}
