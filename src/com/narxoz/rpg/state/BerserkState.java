package com.narxoz.rpg.state;

import com.narxoz.rpg.combatant.Hero;

public class BerserkState implements HeroState {

    public String getName() { return "Berserk"; }

    public int modifyOutgoingDamage(int basePower) {
        return (int)(basePower * 1.5);
    }

    public int modifyIncomingDamage(int rawDamage) {
        return (int)(rawDamage * 1.3);
    }

    public void onTurnStart(Hero hero) {
        if (hero.getHp() < hero.getMaxHp() / 2) {
            System.out.println(hero.getName() + " is enraged!");
        }
    }

    public void onTurnEnd(Hero hero) {}

    public boolean canAct() { return true; }
}