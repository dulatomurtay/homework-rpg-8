package com.narxoz.rpg.floor;

import com.narxoz.rpg.combatant.*;
import com.narxoz.rpg.state.BerserkState;
import java.util.List;

public class FloorBoss extends TowerFloor {

    @Override
    protected String getFloorName() {
        return "Dragon's Lair";
    }

    @Override
    protected void announce() {
        System.out.println("\n🔥 A terrifying boss awaits... 🔥");
    }

    @Override
    protected void setup(List<Hero> party) {
        System.out.println("The ground trembles...");
    }

    @Override
    protected FloorResult resolveChallenge(List<Hero> party) {
        Monster boss = new Monster("Dragon", 100, 20);

        int damage = 0;

        while (boss.isAlive() && party.stream().anyMatch(Hero::isAlive)) {

            for (Hero h : party) {
                if (h.isAlive()) {
                    if (h.getHp() < 30) {
                        h.setState(new BerserkState());
                    }
                    h.takeTurn(boss);
                }
            }
            for (Hero h : party) {
                if (h.isAlive()) {
                    boss.attack(h);
                    damage += 10;
                }
            }
        }
        boolean cleared = !boss.isAlive();
        return new FloorResult(cleared, damage, "Boss defeated");
    }
    @Override
    protected void awardLoot(List<Hero> party, FloorResult result) {
        System.out.println("Legendary treasure acquired!");
    }
}