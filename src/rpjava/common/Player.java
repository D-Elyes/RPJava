/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.common;

/**
 * This class gathers all informations about players
 * @author RPJavaTeam
 */
public class Player extends Character {

// INSTANCE PROPERTIES --------------------------------------------------------
    
    /**
    * Property that will contain the reference to the role of a player
    */
    Role role;
    
    /**
    * Property that will contain the reference to the inventory of a player
    */
    Inventory inv;
    
    /**
    * Property that will contain the reference to the user of a player
    */
    User user;

// CONSTRUCTOR -----------------------------------------------------------------
    
    /**
    * This method creates a Player instance
    * @param user The user who created the player
    * @param role The role of the player
    * @param name The name of the player
    * @param inventorySize The basic size of the inventory of the player
    */
    public Player(User user, Role role, String name, int inventorySize){
        super(name);
        this.user = user;
        this.role = role;
        inv = new Inventory(inventorySize);
    }
    
// GETTERS AND SETTERS ---------------------------------------------------------

    /**
    * This method gets the whole inventory of the player
    * @return Inventory The speech of the player
    */ 
    public Inventory getInventory(){
        return this.inv;
    }

    /**
    * This method gets the role of the player
    * @return Role The role of the player
    */ 
    public Role getRole() {
        return role;
    }
    
    /**
    * This method gets the user of the player
    * @return User The user of the player
    */ 
    public User getUser() {
        return user;
    }

    /**
    * This method change the user of the player
    * @param user The new user of the player
    */
    public void setUser(User user) {
        this.user = user;
    }
    
    /**
    * This method gets the maximum value of health of the player
    * @return int The maximum value of health of the player
    * @see Character#getMaxHp() 
    */
    @Override
    public int getMaxHp() {
        return role.getMaxHp(getLevel());
    }

    /**
    * This method gets the maximum amount of mana of the player
    * @return int The maximum amount of mana of the player
    * @see Character#getMaxMana() 
    */
    @Override
    public int getMaxMana() {
        return role.getMaxMana(getLevel());
    }

    /**
    * This method gets the value of the attack of the player
    * @return float The value of the attack of the player
    * @see Character#getAttack()
    */
    @Override
    public float getAttack() {
        return role.getAttack(getLevel());
    }

    /**
    * This method gets the value of the defence of the player
    * @return float The level of the defence of the current player
    * @see Character#getDefence()
    */
    @Override
    public float getDefence() {
        return role.getDefence(getLevel());
    }
    
}
