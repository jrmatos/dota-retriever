package com.pjomtech.dotaretriever.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class MatchDetailsDTO {
    @JsonProperty("match_id")
    private Long matchId;
    @JsonProperty("game_mode")
    private String gameMode;

    @JsonProperty("start_time")
    private Long startTime;

    @JsonProperty("replay_url")
    private String replayUrl;
    private List<MatchDetailsPlayerDTO> players;
    /**
     * Ranks are represented by integers (10-15: Herald, 20-25: Guardian, 30-35: Crusader, 40-45: Archon, 50-55: Legend,
     * 60-65: Ancient, 70-75: Divine, 80-85: Immortal). Each increment represents an additional star.
     */
    @JsonProperty("rank_tier")
    private Integer rankTier;
}
