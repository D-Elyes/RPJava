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
    private String speech;
    
    public NPC(Race race, String name, boolean isAgressive, boolean isBoss, String speech){
        super(name);
        this.race = race;
        this.isBoss = isBoss;
        this.isAgressive = isAgressive;
        this.speech = speech;
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

    public String getSpeech() {
        return speech;
    }

    public void setSpeech(String speech) {
        this.speech = speech;
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
