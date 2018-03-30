/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.common;

/**
 * This class gathers all informations about equipable items
 * @author RPJavaTeam
 */
public abstract class Equipable extends Item {

// CONSTRUCTOR -----------------------------------------------------------------
    
   /**
    * This method creates an equipable item
    * @param name The name of the item
    * @param description The text that describes the item
    */
    public Equipable(String name, String description) {
        super(name, description);
    }
}
