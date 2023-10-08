package com.pjomtech.dotaretriever.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MatchDetailsPlayerMultiKillsDTO {
    @JsonProperty("2")
    private String two;
    @JsonProperty("3")
    private String three;
    @JsonProperty("4")
    private String four;
    @JsonProperty("5")
    private String five;
}
