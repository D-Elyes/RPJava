/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.common;

import java.util.logging.Level;
import java.util.logging.Logger;
import rpjava.common.races.DefaultRace;

/**
 *
 * @author Florent BERLAND
 */
public abstract class Race {
    
    private int baseHP, baseMana;
    private float baseAttack, baseDefence;
    
    public static Race createFromName(String name){
        String fullName = Race.class.getPackage().getName() + ".races." + name;
        try {
            Class<?> c = Class.forName(fullName);
            return (Race)(c.newInstance());
        } catch (Exception ex) {
            return new DefaultRace();
        }
    }
    
    protected Race(int baseHP, int baseMana, float baseAttack, float baseDefence){
        this.baseHP = baseHP;
        this.baseMana = baseMana;
        this.baseAttack = baseAttack;
        this.baseDefence = baseDefence;
    }
    
    public String getClassName(){
        return this.getClass().getSimpleName();
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
