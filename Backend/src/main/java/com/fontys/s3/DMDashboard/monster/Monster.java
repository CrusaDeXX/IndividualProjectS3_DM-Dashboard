package com.fontys.s3.DMDashboard.monster;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Map;
//Lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
//Database
@Entity
@Table
public class Monster {
    @Id
    @SequenceGenerator(
            name = "monster_sequence",
            sequenceName = "monster_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "monster_sequence"
    )
    private int id;
    private String name;
//    private String monsterType;
//    private String size;
//    private String alignment;
    private int hp;
    private int ac;

    public Monster(String name, int hp, int ac) {
        this.name = name;
        this.hp = hp;
        this.ac = ac;
    }

//    private int ac;
//    private Map<String, Integer> speed;
//    private Map<String, Integer> abilities;
//    private List<String> skills;
//    private List<String> senses;
//    private List<String> languages;
//    private double cr;
//    private List<String> traits;
//    private List<String> actions;
//    private List<String> reactions;
//    private List<String> legendaryActions;
//    private List<String> lairActions;
//    private String description;
}
