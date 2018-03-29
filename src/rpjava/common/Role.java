/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.common;

import rpjava.common.roles.DefaultRole;

/**
 *
 * @author Florent BERLAND
 */
public abstract class Role {
    
    private int baseHP, baseMana;
    private float baseAttack, baseDefence;
    
    public static Role createFromName(String name){
        String fullName = Role.class.getPackage().getName() + ".roles." + name;
        try {
            Class<?> c = Class.forName(fullName);
            return (Role)(c.newInstance());
        } catch (Exception ex) {
            return new DefaultRole();
        }
    }
    
    public String getClassName(){
        return this.getClass().getSimpleName();
    }
    
    protected Role(int baseHP, int baseMana, float baseAttack, float baseDefence){
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
