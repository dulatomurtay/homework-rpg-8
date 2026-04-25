package com.narxoz.rpg.combatant;

import com.narxoz.rpg.state.PoisonedState;
import com.narxoz.rpg.state.StunnedState;

public class Monster {

    private final String name;
    private int hp;
    private final int attackPower;

    public Monster(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
    }

    public String getName() { return name; }
    public boolean isAlive() { return hp > 0; }

    public void takeDamage(int amount) {
        hp = Math.max(0, hp - amount);
        System.out.println(name + " HP=" + hp);
    }

    public void attack(Hero hero) {
        System.out.println(name + " attacks " + hero.getName());
        hero.takeDamage(attackPower);

        double r = Math.random();

        if (r < 0.3) {
            hero.setState(new PoisonedState());
        } else if (r < 0.5) {
            hero.setState(new StunnedState());
        }
    }
}