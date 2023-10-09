package com.pjomtech.dotaretriever.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Hero {
    /** Sample
     * {
     * 		"id": 138,
     * 		"name": "npc_dota_hero_muerta",
     * 		"localized_name": "Muerta",
     * 		"primary_attr": "int",
     * 		"attack_type": "Ranged",
     * 		"roles": [
     * 			"Carry",
     * 			"Nuker",
     * 			"Disabler"
     * 		],
     * 		"legs": 2
     * }
     */
    @Id
    private Integer id;
    private String name;
    @Column(name = "localized_name")
    @JsonProperty("localized_name")
    private String localizedName;
    @Column(name = "primary_attr")
    @JsonProperty("primary_attr")
    private String primaryAttr;
    @Column(name = "attack_type")
    @JsonProperty("attack_type")
    private String attackType;
    private List<String> roles;
    private Integer legs;
}
