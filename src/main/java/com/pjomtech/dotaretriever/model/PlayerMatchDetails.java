package com.pjomtech.dotaretriever.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "player_match_details")
public class PlayerMatchDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Integer playerSlot;
    private Integer laneRole;
    private Integer kills;
    private Long playerAccountId;
    private String playerName;
    private Integer goldPerMin;
}
