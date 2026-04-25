package com.narxoz.rpg;

import com.narxoz.rpg.combatant.*;
import com.narxoz.rpg.floor.*;
import com.narxoz.rpg.state.*;
import com.narxoz.rpg.tower.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== THE HAUNTED TOWER BEGINS ===");

        Hero h1 = new Hero("Superman", 100, 15, 3);
        Hero h2 = new Hero("Flash", 80, 20, 2);

        h2.setState(new BerserkState());

        List<Hero> party = List.of(h1, h2);

        List<TowerFloor> floors = List.of(
                new CombatFloor(),
                new TrapFloor(),
                new RestFloor(),
                new BossFloor()
        );

        TowerRunner runner = new TowerRunner(floors);

        TowerRunResult result = runner.run(party);

        System.out.println("\n=== TOWER RUN COMPLETE ===");
        System.out.println("Floors cleared: " + result.getFloorsCleared());
        System.out.println("Heroes surviving: " + result.getHeroesSurviving());
        System.out.println("Reached top: " + result.isReachedTop());

        System.out.println("\n=== FINAL HERO STATUS ===");
        for (Hero h : party) {
            System.out.println(h.getName() + " HP: " + h.getHp());
        }
    }
}