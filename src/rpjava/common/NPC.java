/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.common;

/**
 *
 * @author Florent BERLAND
 */
public class NPC extends Character {
    
    private Race race;
    
    public NPC(Race race, String name){
        super(name);
        this.race = race;
    }

    @Override
    public int getMaxHp() {
        return race.getMaxHp(getLevel());
    }

    @Override
    public int getMaxMana() {
        return race.getMaxMana(getLevel());
    }

    @Override
    public float getAttack() {
        return race.getAttack(getLevel());
    }

    @Override
    public float getDefence() {
        return race.getDefence(getLevel());
    }
}
