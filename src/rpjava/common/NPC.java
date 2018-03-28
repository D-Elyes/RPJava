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
    private boolean isBoss;
    private boolean isAgressive;
    
    public NPC(Race race, String name, boolean isBoss, boolean isAgressive){
        super(name);
        this.race = race;
        this.isBoss = isBoss;
        this.isAgressive = isAgressive;
    }

    public boolean isBoss() {
        return isBoss;
    }

    public void setBoss(boolean isBoss) {
        this.isBoss = isBoss;
    }

    public boolean isAgressive() {
        return isAgressive;
    }

    public void setAgressive(boolean isAgressive) {
        this.isAgressive = isAgressive;
    }

    public Race getRace() {
        return race;
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
