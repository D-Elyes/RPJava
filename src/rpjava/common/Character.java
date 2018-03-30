/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.common;

/**
 * This class gathers all informations about characters
 * @author RPJavaTeam
 */
public abstract class Character {

// INSTANCE PROPERTIES ---------------------------------------------------------
    
    /**
    * Properties that correspond to basic caracteristics of our character
    */
    private int hp, mana;
    private float xp;
    private String name;

// CONSTRUCTORS -----------------------------------------------------------------
    
    /**
    * This method constructs a new Character instance
    * @param name The name the user gave to his character
    */
    protected Character(String name){
        this.name = name;
        this.xp = 0;
        this.hp = getMaxHp();
        this.mana = getMaxMana();
    }
    
    /**
    * This method constructs a new Character instance
    * @param name The name the user gave to his character
    * @param xp The current level of experience of the character
    * @param hp The current level of life of the character
    * @param mana The current amount of mama of the character
    */
    protected Character(String name, float xp, int hp, int mana){
        this.name = name;
        this.xp = xp;
        this.hp = hp;
        this.mana = mana;
    }

// GETTERS AND SETTERS ---------------------------------------------------------
    
    /**
    * This method gets the level of the character
    * @return int The level of the current character
    */
    public int getLevel(){
        return (int)Math.pow(xp/20, .8) + 1;
    }
    
    /**
    * This method change the level of the character
    * @param value The new value of the level
    */
    public void setLevel(int value){
        xp = (float)(20/Math.pow(value-1, .8));
    }
    
    /**
    * This abstract method gets the maximum value of health of the character
    * @return int The maximum value of health of the character
    */
    public abstract int getMaxHp();
    
    /**
    * This abstract method gets the maximum amount of mana of the character
    * @return int The maximum amount of mana of the character
    */
    public abstract int getMaxMana();
    
    /**
    * This abstract method gets the value of the attack of the character
    * @return float The value of the attack of the character
    */
    public abstract float getAttack();
    
    /**
    * This abstract method gets the value of the defence of the character
    * @return float The level of the defence of the current character
    */
    public abstract float getDefence();
    
    /**
    * This method gets the level of current health of the character
    * @return int The level of the current health of the chararcter
    */
    public int getHp() {
        return hp;
    }

    /**
    * This method change the level of health of the character
    * @param hp The new value of health
    */
    public void setHp(int hp) {
        this.hp = hp;
    }
    /**
    * This method gets the current amount of mana of the character
    * @return int The level of the current life of the chararcter
    */
    public int getMana() {
        return mana;
    }

    /**
    * This method change the amount of mana
    * @param mana The new value of mana
    */
    public void setMana(int mana) {
        this.mana = mana;
    }

    /**
    * This method gets the current level of experience of the character
    * @return int The level of the current life of the chararcter
    */
    public float getXp() {
        return xp;
    }

    /**
    * This method change the level of experience
    * @param xp The new value of experience
    */
    public void setXp(float xp) {
        this.xp = xp;
    }

    /**
    * This method gets the name of the character
    * @return int The name of the chararcter
    */
    public String getName() {
        return name;
    }

    /**
    * This method change the name of the character
    * @param name The new name of the character
    */
    public void setName(String name) {
        this.name = name;
    }
    
}
