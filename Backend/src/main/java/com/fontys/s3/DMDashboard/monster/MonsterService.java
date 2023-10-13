package com.fontys.s3.DMDashboard.monster;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MonsterService {

    private final MonsterRepository monsterRepository;
    @Autowired
    public MonsterService(MonsterRepository monsterRepository) {
        this.monsterRepository = monsterRepository;
    }


    public List<Monster> getMonsters() {
        return monsterRepository.findAll();
    }

    public void addNewMonster(Monster monster) {
        Optional<Monster> monsterOptional = monsterRepository
                .findMonsterByName(monster.getName());
        if(monsterOptional.isPresent()){
            throw new IllegalStateException("Monster already used");
        }
        monsterRepository.save(monster);
        System.out.println(monster);
    }

    public void deleteMonster(int monsterId) {
        boolean exists = monsterRepository.existsById(monsterId);
        if(!exists){
            throw new IllegalStateException(
                    "monster with id " + monsterId + " does not exist");
        }
        monsterRepository.deleteById(monsterId);
    }
    //Currently its throwing an error if you don't give one of these fields, i need to figure out how to fix.
    //Maybe look more into transactional?
    @Transactional
    public void updateMonster(int monsterId, String name, int hp, int ac) {
        Monster monster = monsterRepository.findById(monsterId)
                .orElseThrow(() -> new IllegalStateException(
                        "monster with id " + monsterId + " does not exist"
                ));
        if(name != null &&
                !name.isEmpty() &&
                !Objects.equals(monster.getName(), name)){
            monster.setName(name);
        }
        if(hp != 0){
            monster.setHp(hp);
        }
        if(ac >= 0){
            monster.setAc(ac);
        }
    }
}
