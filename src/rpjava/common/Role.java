/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.common;

import java.util.*;
import rpjava.common.roles.*;

/**
 * This class gathers all informations about roles
 * @author RPJavaTeam
 * @version 1.0
 */

public abstract class Role {
    
    /**
    * Property that will contain the basic caracteristics of a role
    */
    private int baseHP, baseMana;
    private float baseAttack, baseDefence;
 
// CLASS METHOD --------------------------------------------------------  
    
    /**
    * This method allows whom calls it to create a Role if its name does not exist
    * @param name The name of the role
    * @return Role The new created role
    */   
    
    public static Role createFromName(String name){
        String fullName = Role.class.getPackage().getName() + ".roles." + name;
        try {
            Class<?> c = Class.forName(fullName);
            return (Role)(c.newInstance());
        } catch (Exception ex) {
            return new DefaultRole();
        }
    }
    
    public static Collection<Role> getAllRoles(){
        Collection<Role> col = new HashSet<>();
        col.add(new Ranger());
        col.add(new Warrior());
        col.add(new Wizzard());
        return col;
    }
    
// CONSTRUCTOR -----------------------------------------------------------------
    
     /**
    * This method creates a new Role instance
    * @param baseHP The basic level of health of the role
    * @param baseMana The basic amount of mana of the role
    * @param baseAttack The basic level of attack of the role
    * @param baseDefence The basic level of defence of the role
    */
     protected Role(int baseHP, int baseMana, float baseAttack, float baseDefence){
        this.baseHP = baseHP;
        this.baseMana = baseMana;
        this.baseAttack = baseAttack;
        this.baseDefence = baseDefence;
    }   
    
// INSTANCE METHODS ------------------------------------------------------------
  
     /**
    * This method gets the simple class name of the role
    * @return String The class name of the role
    */ 
    public String getClassName(){
        return this.getClass().getSimpleName();
    }
    
    /**
    * This abstract method gets the role name of the role
    * @return int The role name of the role 
    */
    public abstract String getRoleName();
    
     /**
    * This abstract method gets the maximum value of health of the role linked to its level
    * @param level The level of the role
    * @return int The maximum value of health of the role
    */
    public abstract int getMaxHp(int level);
    
    /**
    * This abstract method gets the maximum amount of mana of the role linked to its level
    * @param level The level of the role
    * @return int The maximum amount of mana of the role
    */
    public abstract int getMaxMana(int level);
    
     /**
    * This abstract method gets the value of the attack of the role linked to its level
    * @param level The level of the role
    * @return float The value of the attack of the role
    */
    public abstract float getAttack(int level);
    
    /**
    * This abstract method gets the value of the defence of the role linked to its level
    * @param level The level of the role
    * @return float The level of the defence of the role
    */
    public abstract float getDefence(int level);

    /**
    * This method gets the basic value of health of the role
    * @return int The basic value of health of the role    
    */
    public int getBaseHP() {
        return baseHP;
    }

    /**
    * This method gets the basic amount of mana of the role
    * @return int The basic amount of mana of the role   
    */
    public int getBaseMana() {
        return baseMana;
    }

    /**
    * This method gets the basic value of attack of the role
    * @return float The basic value of attack of the role   
    */
    public float getBaseAttack() {
        return baseAttack;
    }

    /**
    * This method gets the basic value of defence of the role
    * @return float The basic value of defence of the role   
    */
    public float getBaseDefence() {
        return baseDefence;
    }
}
