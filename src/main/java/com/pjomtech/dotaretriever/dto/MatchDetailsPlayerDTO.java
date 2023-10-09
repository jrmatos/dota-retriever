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

    @JsonProperty("lane_role")
    private Integer laneRole;

    private Integer kills;

    @JsonProperty("account_id")
    private Long accountId;

    private String name;

    @JsonProperty("gold_per_min")
    private Integer goldPerMin;

    @JsonProperty("hero_id")
    private Integer heroId;
}
