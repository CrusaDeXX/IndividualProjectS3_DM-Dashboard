package com.fontys.s3.DMDashboard.monster;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MonsterRepository extends JpaRepository<Monster, Integer> {
    //SELECT * FROM monster WHERE name = ?
    @Query("SELECT m FROM Monster m WHERE m.name = ?1")
    Optional<Monster> findMonsterByName(String name);
}
