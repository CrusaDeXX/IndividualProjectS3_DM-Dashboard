package com.fontys.s3.DMDashboard.monster;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MonsterConfig {
    @Bean
    CommandLineRunner commandLineRunner (MonsterRepository repository){
        return args -> {
            Monster goblin = new Monster(
                    "Goblin",
                    6,
                    12);
            Monster wolf = new Monster(
                    "Wolf",
                    7,
                    14);
            repository.saveAll(
                    List.of(goblin, wolf)
            );
        };
    };

}
