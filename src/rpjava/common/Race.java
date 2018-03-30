/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.common;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import rpjava.common.races.*;

/**
 * This class gathers all informations about races
 * @author RPJavaTeam
 * @version 1.0
 */

public abstract class Race {
 
// INSTANCE PROPERTIES --------------------------------------------------------
    
    /**
    * Property that will contain the basic caracteristics of a role
    */
    private int baseHP, baseMana;
    private float baseAttack, baseDefence;
 
// CLASS METHOD --------------------------------------------------------  
    
    /**
    * This method allows whom calls it to create a Race if its name does not exist
    * @param name The name of the race
    * @return Race The new created race
    */
    public static Race createFromName(String name){
        String fullName = Race.class.getPackage().getName() + ".races." + name;
        try {
            Class<?> c = Class.forName(fullName);
            return (Race)(c.newInstance());
        } catch (Exception ex) {
            return new DefaultRace();
        }
    }
    
        
    public static Collection<Race> getAllRaces(){
        Collection<Race> col = new HashSet<>();
        col.add(new Griffin());
        col.add(new Human());
        col.add(new Werewolf());
        return col;
    }
   
// CONSTRUCTOR -----------------------------------------------------------------
    
    /**
    * This method creates a new Race instance
    * @param baseHP The basic level of health of the race
    * @param baseMana The basic amount of mana of the race
    * @param baseAttack The basic level of attack of the race
    * @param baseDefence The basic level of defence of the race
    */
    protected Race(int baseHP, int baseMana, float baseAttack, float baseDefence){
        this.baseHP = baseHP;
        this.baseMana = baseMana;
        this.baseAttack = baseAttack;
        this.baseDefence = baseDefence;
    }
    
// GETTERS AND SETTERS --------------------------------------------------------

     /**
    * This method gets the simple class name of the race
    * @return String The class name of the race
    */
    public String getClassName(){
        return this.getClass().getSimpleName();
    }
    
     /**
    * This abstract method gets the role name of the race
    * @return int The role name of the race 
    */
    public abstract String getRoleName();
    
    /**
    * This abstract method gets the maximum value of health of the race linked to its level
    * @param level The level of the race
    * @return int The maximum value of health of the race
    */
    public abstract int getMaxHp(int level);
    
    /**
    * This abstract method gets the maximum amount of mana of the race linked to its level
    * @param level The level of the race
    * @return int The maximum amount of mana of the race
    */
    public abstract int getMaxMana(int level);
    
    /**
    * This abstract method gets the value of the attack of the race linked to its level
    * @param level The level of the race
    * @return float The value of the attack of the race
    */
    public abstract float getAttack(int level);
    
    /**
    * This abstract method gets the value of the defence of the race linked to its level
    * @param level The level of the race
    * @return float The level of the defence of the race
    */
    public abstract float getDefence(int level);

    /**
    * This method gets the basic value of health of the race
    * @return int The basic value of health of the race    
    */
    public int getBaseHP() {
        return baseHP;
    }

    /**
    * This method gets the basic amount of mana of the race
    * @return int The basic amount of mana of the race   
    */
    public int getBaseMana() {
        return baseMana;
    }

    /**
    * This method gets the basic value of attack of the race
    * @return float The basic value of attack of the race   
    */
    public float getBaseAttack() {
        return baseAttack;
    }

    /**
    * This method gets the basic value of defence of the race
    * @return float The basic value of defence of the race   
    */
    public float getBaseDefence() {
        return baseDefence;
    }
    
}
