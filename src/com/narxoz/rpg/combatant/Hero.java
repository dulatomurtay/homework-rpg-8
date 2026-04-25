package com.narxoz.rpg.combatant;

import com.narxoz.rpg.state.HeroState;
import com.narxoz.rpg.state.NormalState;

public class Hero {

    private final String name;
    private int hp;
    private final int maxHp;
    private final int attackPower;
    private final int defense;

    private HeroState state;

    public Hero(String name, int hp, int attackPower, int defense) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.attackPower = attackPower;
        this.defense = defense;

        this.state = new NormalState();
    }

    public String getName()        { return name; }
    public int getHp()             { return hp; }
    public int getMaxHp()          { return maxHp; }
    public int getAttackPower()    { return attackPower; }
    public int getDefense()        { return defense; }
    public boolean isAlive()       { return hp > 0; }

    public HeroState getState() {
        return state;
    }

    public void setState(HeroState newState) {
        if (newState == null) return;
        System.out.println(name + " changes state → " + newState.getName());
        this.state = newState;
    }

    public int attack() {
        return state.modifyOutgoingDamage(attackPower);
    }

    public void takeDamage(int amount) {
        int reduced = Math.max(0, amount - defense);

        int finalDamage = state.modifyIncomingDamage(reduced);

        hp = Math.max(0, hp - finalDamage);

        System.out.println(name + " takes " + finalDamage + " damage (HP: " + hp + ")");
    }

    public void heal(int amount) {
        hp = Math.min(maxHp, hp + amount);
        System.out.println(name + " heals " + amount + " (HP: " + hp + ")");
    }
    public void takeTurn(Monster monster) {
        if (!isAlive()) return;

        System.out.println("[" + name + " | State: " + state.getName() + "]");
        state.onTurnStart(this);

        if (state.canAct()) {
            int dmg = attack();
            System.out.println(name + " attacks for " + dmg);
            monster.takeDamage(dmg);
        } else {
            System.out.println(name + " cannot act this turn!");
        }
        state.onTurnEnd(this);
    }
}