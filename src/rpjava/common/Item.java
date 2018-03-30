/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.common;

/**
 * This class gathers all informations about items
 * @author RPJavaTeam
 */
public class Item {

// INSTANCE PROPERTIES --------------------------------------------------------
    
    /**
    * Property that will contain the name and the description of an item
    */
    private String name, description;

// CONSTRUCTOR -----------------------------------------------------------------
    
    /**
    * This method creates an Item instance
    * @param name The name of the item
    * @param description The description of the item
    */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

// GETTERS AND SETTERS ---------------------------------------------------------
    
    /**
    * This method gets the name of the item
    * @return String The name of the inventory
    */   
    public String getName() {
        return name;
    }

    /**
    * This method change the name of the item
    * @param name The new name of the item
    */
    public void setName(String name) {
        this.name = name;
    }

    /**
    * This method gets the description of the item
    * @return String The description of the item
    */  
    public String getDescription() {
        return description;
    }

    /**
    * This method change the description of the item
    * @param description The new description of the item
    */
    public void setDescription(String description) {
        this.description = description;
    }
    
}
