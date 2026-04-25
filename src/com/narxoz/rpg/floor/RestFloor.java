package com.narxoz.rpg.floor;

import com.narxoz.rpg.combatant.*;
import java.util.List;

public class RestFloor extends TowerFloor {

    @Override
    protected String getFloorName() {
        return "Safe Haven";
    }

    @Override
    protected void announce() {
        System.out.println("\n✨ You discovered a peaceful sanctuary ✨");
    }

    @Override
    protected void setup(List<Hero> party) {
        System.out.println("The heroes take a moment to rest...");
    }

    @Override
    protected FloorResult resolveChallenge(List<Hero> party) {
        for (Hero h : party) {
            if (h.isAlive()) {
                h.heal(20);
            }
        }
        return new FloorResult(true, 0, "Rest completed");
    }

    @Override
    protected boolean shouldAwardLoot(FloorResult result) {
        return false;
    }

    @Override
    protected void awardLoot(List<Hero> party, FloorResult result) {
    }

    @Override
    protected void cleanup(List<Hero> party) {
        System.out.println("Heroes feel refreshed and ready.");
    }
}