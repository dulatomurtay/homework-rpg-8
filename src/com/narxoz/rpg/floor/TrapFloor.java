package com.narxoz.rpg.floor;

import com.narxoz.rpg.combatant.*;
import com.narxoz.rpg.state.PoisonedState;
import java.util.List;

public class TrapFloor extends TowerFloor {

    @Override
    protected String getFloorName() {
        return "Poison Trap Room";
    }

    @Override
    protected void setup(List<Hero> party) {
        System.out.println("Hidden traps activate!");
    }

    @Override
    protected FloorResult resolveChallenge(List<Hero> party) {
        int damage = 0;

        for (Hero h : party) {
            if (h.isAlive()) {
                h.takeDamage(10);
                h.setState(new PoisonedState()); 
                damage += 10;
            }
        }
        return new FloorResult(true, damage, "Trap triggered");
    }
    @Override
    protected void awardLoot(List<Hero> party, FloorResult result) {
        System.out.println("You find a small chest.");
    }
}