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
public abstract class Character {
    
    private int hp, mana;
    private float xp;
    private String name;

    protected Character(String name){
        this.name = name;
        this.xp = 0;
        this.hp = getMaxHp();
        this.mana = getMaxMana();
    }
    protected Character(String name, float xp, int hp, int mana){
        this.name = name;
        this.xp = xp;
        this.hp = hp;
        this.mana = mana;
    }
    
    public int getLevel(){
        return (int)Math.pow(xp/20, .8) + 1;
    }
    
    public void setLevel(int value){
        xp = (float)(20/Math.pow(value-1, .8));
    }
    
    public abstract int getMaxHp();
    public abstract int getMaxMana();
    public abstract float getAttack();
    public abstract float getDefence();
    
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public float getXp() {
        return xp;
    }

    public void setXp(float xp) {
        this.xp = xp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
