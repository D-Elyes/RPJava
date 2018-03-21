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
public abstract class Race {
    
    private int baseHP, baseMana;
    private float baseAttack, baseDefence;
    
    protected Race(int baseHP, int baseMana, float baseAttack, float baseDefence){
        this.baseHP = baseHP;
        this.baseMana = baseMana;
        this.baseAttack = baseAttack;
        this.baseDefence = baseDefence;
    }
    
    public abstract String getRoleName();
    public abstract int getMaxHp(int level);
    public abstract int getMaxMana(int level);
    public abstract float getAttack(int level);
    public abstract float getDefence(int level);

    public int getBaseHP() {
        return baseHP;
    }

    public int getBaseMana() {
        return baseMana;
    }

    public float getBaseAttack() {
        return baseAttack;
    }

    public float getBaseDefence() {
        return baseDefence;
    }
    
}
