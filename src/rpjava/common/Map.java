/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.common;

import java.util.*;

/**
 * This class gathers all informations about maps
 * @author RPJavaTeam
 */
public class Map {
  
// INSTANCE PROPERTIES --------------------------------------------------------
    
    /**
    * Property that will contain the id of a map
    */
    private int id;
    
    /**
    * Property that will contain the name of a map
    */
    private String name;
    
    /**
    * Property that will contain the list of the rooms 
    */
    private Collection<Room> rooms;
    
// CONSTRUCTORs -----------------------------------------------------------------
    
    /**
    * This method creates an Map instance
    * @param id The id reference of the map
    * @param name The name of the map
    */
    public Map(int id, String name){
        this.id = id;
        this.name = name;
    }
    
    /**
    * This method creates an Map instance
    * @param id The id reference of the map
    * @param name The name of the map
    * @param rooms The list of rooms of the map
    */
    public Map(int id, String name, Collection<Room> rooms){
        this.id = id;
        this.name = name;
        this.rooms = rooms;
    }

// GETTERS AND SETTERS ---------------------------------------------------------
    
    /**
    * This method gets the id of the map
    * @return int The id of the map
    */ 
    public int getId() {
        return id;
    }

    /**
    * This method change the id of the map
    * @param id The new id of the map
    */
    public void setId(int id) {
        this.id = id;
    }

    /**
    * This method gets the name of the map
    * @return String The name of the map
    */ 
    public String getName() {
        return name;
    }

    /**
    * This method change the name of the map
    * @param name The new name of the map
    */
    public void setName(String name) {
        this.name = name;
    }

    /**
    * This method gets the list of the rooms of the map
    * @return Collection<Room> The list of the rooms of the map
    */ 
    public Collection<Room> getRooms() {
        return rooms;
    }

    /**
    * This method change the set of rooms of the map
    * @param rooms The new set of rooms of the map
    */
    public void setRooms(Collection<Room> rooms) {
        this.rooms = rooms;
    }
    
}
