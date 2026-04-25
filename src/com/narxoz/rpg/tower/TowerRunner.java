package com.narxoz.rpg.tower;

import com.narxoz.rpg.floor.*;
import com.narxoz.rpg.combatant.*;
import java.util.List;

public class TowerRunner {

    private final List<TowerFloor> floors;

    public TowerRunner(List<TowerFloor> floors) {
        this.floors = floors;
    }

    public TowerRunResult run(List<Hero> party) {
        int cleared = 0;

        for (TowerFloor f : floors) {
            FloorResult r = f.explore(party);

            System.out.println("➡ " + r.getSummary());
            System.out.println("Damage taken: " + r.getDamageTaken());

            if (!r.isCleared()) break;
            cleared++;

            if (party.stream().noneMatch(Hero::isAlive)) break;
        }
        int surviving = (int) party.stream()
                .filter(Hero::isAlive)
                .count();

        boolean reachedTop = cleared == floors.size();

        return new TowerRunResult(cleared, surviving, reachedTop);
    }
}