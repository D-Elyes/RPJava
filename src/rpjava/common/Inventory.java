/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.common;

import java.util.*;

/**
 * This class gathers all informations about inventory
 * @author RPJavaTeam
 */
public class Inventory {

// INSTANCE PROPOERTIES --------------------------------------------------------
    
<<<<<<< Updated upstream
    private java.util.Map<Item,Integer> items;
=======
    /**
    * Property that will contain a vector in which each item the character owes is linked to the number of items there are in the inventory
    */
    private Map<Item,Integer> items;
    
    /**
    * Property that shows the size of the inventory
    */
>>>>>>> Stashed changes
    private int size;
    
// CONSTRUCTOR -----------------------------------------------------------------
    
    /**
    * This method creates an inventory of a given size
    * @param size The size of the inventory
    */
    public Inventory(int size){
        items = new HashMap<>();
    }
    
// INSTANCE METHODS -----------------------------------------------------------------

    /**
    * This method add an item into an inventory
    * @param i The item to add
    * @return Boolean True if the item is correctly added, else False
    */
    public boolean addItem(Item i){
        if(items.containsKey(i)){
            items.put(i, items.get(i) + 1);
            return true;
        } else if(items.size() < size){
            items.put(i, 1);
            return true;
        } else {
            return false;
        }
    }
    
    /**
    * This method remove an item from an inventory
    * @param i The item to remove
    */
    public void removeItem(Item i){
        if(items.containsKey(i)){
            items.put(i, items.get(i) - 1);
            if(items.get(i) == 0){
                items.remove(i);
            }
        }
    }
    
    /**
    * This method remove (use) an occurence of an item from an inventory
    * @param i The item to use
    */
    public void removeStack(Item i){
        items.remove(i);
    }

// GETTERS AND SETTERS ---------------------------------------------------------
   
    /**
    * This method gets the size of the inventory
    * @return int The size of the inventory
    */
    public int getSize() {
        return size;
    }

     /**
    * This method change the size of the inventory
    * @param size The new size of the inventory
    */
    public void setSize(int size) {
        this.size = size;
    }
    
}