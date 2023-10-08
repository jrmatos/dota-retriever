package com.pjomtech.dotaretriever.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "parsed_match")
public class ParsedMatch {
    @Id
    @Column(name = "match_id")
    @JsonProperty("match_id")
    private Long matchId;
    private Boolean checked;
}
