package com.fontys.s3.DMDashboard.monster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/monster")
public class MonsterController {

    private final MonsterService monsterService;

    @Autowired
    public MonsterController(MonsterService monsterService) {
        this.monsterService = monsterService;
    }

    @GetMapping
    public List<Monster> getMonsters() {
        return monsterService.getMonsters();
    }

    @PostMapping
    public void registerNewMonster(@RequestBody Monster monster){
        monsterService.addNewMonster(monster);
    }

    @DeleteMapping(path = "{monsterId}")
    public void deleteMonster(@PathVariable("monsterId") int monsterId){
        monsterService.deleteMonster(monsterId);
    }

    @PutMapping(path = "{monsterId}")
    public void updateMonster(
            @PathVariable("monsterId") int monsterId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer hp,
            @RequestParam(required = false) Integer ac
            ){
        monsterService.updateMonster(monsterId, name, hp, ac);
    }
}
