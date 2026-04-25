package com.narxoz.rpg.floor;

import com.narxoz.rpg.combatant.*;
import java.util.List;

public class CombatFloor extends TowerFloor {

    @Override
    protected String getFloorName() {
        return "Goblin Arena";
    }

    @Override
    protected void setup(List<Hero> party) {
        System.out.println("A wild monster appears!");
    }

    @Override
    protected FloorResult resolveChallenge(List<Hero> party) {
        Monster monster = new Monster("Goblin", 50, 10);

        int totalDamage = 0;

        while (monster.isAlive() && party.stream().anyMatch(Hero::isAlive)) {

            for (Hero h : party) {
                if (h.isAlive()) {
                    h.takeTurn(monster);
                }
            }
            for (Hero h : party) {
                if (h.isAlive()) {
                    monster.attack(h);
                    totalDamage += 5;
                }
            }
        }
        boolean cleared = !monster.isAlive();
        return new FloorResult(cleared, totalDamage, "Combat finished");
    }
    @Override
    protected void awardLoot(List<Hero> party, FloorResult result) {
        System.out.println("Heroes receive gold and feel stronger!");
    }
}