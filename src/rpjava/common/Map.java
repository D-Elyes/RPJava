/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.common;

import java.util.*;

/**
 *
 * @author Florent BERLAND
 */
public class Map {
    
    private int id;
    private String name;
    private Collection<Room> rooms;
    
    public Map(int id, String name){
        this.id = id;
        this.name = name;
    }
    
    public Map(int id, String name, Collection<Room> rooms){
        this.id = id;
        this.name = name;
        this.rooms = rooms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Collection<Room> rooms) {
        this.rooms = rooms;
    }
    
}
