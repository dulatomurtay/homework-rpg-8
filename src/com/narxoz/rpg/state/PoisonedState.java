package com.narxoz.rpg.state;

import com.narxoz.rpg.combatant.Hero;

public class PoisonedState implements HeroState {

    private int turns = 3;

    public String getName() { return "Poisoned"; }

    public int modifyOutgoingDamage(int basePower) {
        return (int)(basePower * 0.8);
    }

    public int modifyIncomingDamage(int rawDamage) {
        return rawDamage;
    }

    public void onTurnStart(Hero hero) {
        System.out.println(hero.getName() + " suffers poison!");
        hero.takeDamage(5);
    }

    public void onTurnEnd(Hero hero) {
        turns--;
        if (turns <= 0) {
            hero.setState(new NormalState());
        }
    }

    public boolean canAct() { return true; }
}