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
public class Inventory {
    
    private Map<Item,Integer> items;
    private int size;
    
    public Inventory(int size){
        items = new HashMap<>();
    }

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
    
    public void removeItem(Item i){
        if(items.containsKey(i)){
            items.put(i, items.get(i) - 1);
            if(items.get(i) == 0){
                items.remove(i);
            }
        }
    }
    
    public void removeStack(Item i){
        items.remove(i);
    }
    
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
}
