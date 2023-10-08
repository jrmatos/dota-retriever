package com.pjomtech.dotaretriever.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class MatchDetails {
    @Id
    @Column(name = "match_id")
    @JsonProperty("match_id")
    private Long matchId;
}
