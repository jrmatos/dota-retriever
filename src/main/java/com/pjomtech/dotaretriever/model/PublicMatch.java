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
@Table(name = "public_match")
public class PublicMatch {
    /** Sample
     * 	    "match_id": 7371184207,
     * 		"match_seq_num": 6204797108,
     * 		"radiant_win": false,
     * 		"start_time": 1696726070,
     * 		"duration": 432,
     * 		"avg_mmr": 4735,
     * 		"num_mmr": 3,
     * 		"lobby_type": 7,
     * 		"game_mode": 22,
     * 		"avg_rank_tier": 81,
     * 		"num_rank_tier": 6,
     * 		"cluster": 122,
     * 		"radiant_team": "64,30,114,53,42",
     * 		"dire_team": "20,41,32,11,62"
     */
    @Id
    @Column(name = "match_id")
    @JsonProperty("match_id")
    private Long matchId;

    @Column(name = "match_seq_num")
    @JsonProperty("match_seq_num")
    private Long matchSeqNum;

    @Column(name = "radiant_win")
    @JsonProperty("radiant_win")
    private Boolean radiantWin;

    @Column(name = "start_time")
    @JsonProperty("start_time")
    private Long startTime;

    private Integer duration;

    @Column(name = "avg_mmr")
    @JsonProperty("avg_mmr")
    private Integer avgMmr;

    @Column(name = "num_mmr")
    @JsonProperty("num_mmr")
    private Integer numMmr;

    @Column(name = "lobby_type")
    @JsonProperty("lobby_type")
    private Integer lobbyType;

    @Column(name = "game_mode")
    @JsonProperty("game_mode")
    private Integer gameMode;

    @Column(name = "avg_rank_tier")
    @JsonProperty("avg_rank_tier")
    private Integer avgRankTier;

    @Column(name = "num_rank_tier")
    @JsonProperty("num_rank_tier")
    private Integer numRankTier;
    private Integer cluster;

    @Column(name = "radiant_team")
    @JsonProperty("radiant_team")
    private String radiantTeam;

    @Column(name = "dire_team")
    @JsonProperty("dire_team")
    private String direTeam;

    private Boolean checked;
}
