/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.common;

/**
 * This class gathers all informations about non-playable charaters (npc)
 * @author RPJavaTeam
 */
public class NPC extends Character {
    
// INSTANCE PROPERTIES --------------------------------------------------------
    
    /**
    * Property that will contain the race of a npc
    */
    private Race race;
    
    /**
    * Property that will show if the npc is a Boss (True), or if it is not (False)
    */
    private boolean isBoss;
    
    /**
    * Property that will show if the npc is aggressive (True), or if it is not (False)
    */
    private boolean isAgressive;
    
    /**
    * Property that will contain what the npc has to say
    */
    private String speech;
 
// CONSTRUCTOR -----------------------------------------------------------------
    
    /**
    * This method creates an NPC instance
    * @param race The race of the npc
    * @param name The name of the npc
    * @param isAgressive A boolean depending on the type of the npc
    * @param isBoss A boolean depending on the type of the npc
    * @param speech A text that shows what the npc has to say
    */
    public NPC(Race race, String name, boolean isAgressive, boolean isBoss, String speech){
        super(name);
        this.race = race;
        this.isBoss = isBoss;
        this.isAgressive = isAgressive;
        this.speech = speech;
    }
 
// INSTANCE METHODS ------------------------------------------------------------
    
    /**
    * This method shows if the npc is a boss or if it is not
    * @return Boolean True if the npc is a boss, False else.
    */
    public boolean isBoss() {
        return isBoss;
    }

    public void setBoss(boolean isBoss) {
        this.isBoss = isBoss;
    }

    /**
    * This method shows if the npc is agressive or if it is not
    * @return Boolean True if the npc is a boss, False else.
    */
    public boolean isAgressive() {
        return isAgressive;
    }

// GETTERS AND SETTERS --------------------------------------------------------

    
    /**
    * This method change the behaviour of the npc
    * @param isAgressive The new behaviour of the npc
    */
    public void setAgressive(boolean isAgressive) {
        this.isAgressive = isAgressive;
    }

    /**
    * This method gets the race of the npc
    * @return Race The race of the npc
    */ 
    public Race getRace() {
        return race;
    }

    /**
    * This method gets the speech of the npc
    * @return Race The speech of the npc
    */ 
    public String getSpeech() {
        return speech;
    }

     /**
    * This method change the speech of the npc
    * @param speech The new speech of the npc
    */
    public void setSpeech(String speech) {
        this.speech = speech;
    }
    
    /**
    * This method gets the maximum value of health of the npc
    * @return int The maximum value of health of the npc
    * @see Character#getMaxHp() 
    */
    @Override
    public int getMaxHp() {
        return race.getMaxHp(getLevel());
    }

    /**
    * This method gets the maximum amount of mana of the npc
    * @return int The maximum amount of mana of the npc
    * @see Character#getMaxMana() 
    */
    @Override
    public int getMaxMana() {
        return race.getMaxMana(getLevel());
    }

    /**
    * This method gets the value of the attack of the npc
    * @return float The value of the attack of the npc
    * @see Character#getAttack()
    */
    @Override
    public float getAttack() {
        return race.getAttack(getLevel());
    }

    /**
    * This method gets the value of the defence of the npc
    * @return float The level of the defence of the current npc
    * @see Character#getDefence()
    */
    @Override
    public float getDefence() {
        return race.getDefence(getLevel());
    }
}
