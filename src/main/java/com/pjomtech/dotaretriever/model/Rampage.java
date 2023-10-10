package com.pjomtech.dotaretriever.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Rampage {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "match_id")
    @NotNull
    private Long matchId;

    @ManyToOne
    @JoinColumn(name = "hero_id")
    private Hero hero;

    @Column(name = "start_time")
    private Long startTime;

    @Column(name = "action_start")
    private Integer actionStart;

    @Column(name = "rank_tier")
    private Integer rankTier;

    @Column(name = "replay_url")
    private String replayUrl;
}
