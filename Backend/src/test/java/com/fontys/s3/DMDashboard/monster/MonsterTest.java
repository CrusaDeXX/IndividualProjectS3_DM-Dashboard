package com.fontys.s3.DMDashboard.monster;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonsterTest {

    @Test
    void getName() {
        Monster monster = new Monster("Dragon", 200, 20);
        assertEquals("Dragon", monster.getName());
    }

    @Test
    void getHp() {
        Monster monster = new Monster("Dragon", 200, 20);
        assertEquals(200, monster.getHp());
    }

    @Test
    void getAc() {
        Monster monster = new Monster("Dragon", 200, 20);
        assertEquals(20, monster.getAc());
    }

    @Test
    void setName() {
        Monster monster = new Monster("Dragon", 200, 20);
        monster.setName("Zombie");
        assertEquals("Zombie", monster.getName());
    }

    @Test
    void setHp() {
        Monster monster = new Monster("Dragon", 200, 20);
        monster.setHp(2000);
        assertEquals(2000, monster.getHp());
    }

    @Test
    void setAc() {
        Monster monster = new Monster("Dragon", 200, 20);
        monster.setAc(10);
        assertEquals(10, monster.getAc());
    }
}