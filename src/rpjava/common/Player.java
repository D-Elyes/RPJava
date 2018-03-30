/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.common;

/**
 *
 * @author FLorent BERLAND
 */
public class Player extends Character {

    Role role;
    Inventory inv;
    User user;
    
    public Player(User user, Role role, String name, int inventorySize){
        super(name);
        this.user = user;
        this.role = role;
        inv = new Inventory(inventorySize);
    }
    
    public Inventory getInventory(){
        return this.inv;
    }

    public Role getRole() {
        return role;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    @Override
    public int getMaxHp() {
        return role.getMaxHp(getLevel());
    }

    @Override
    public int getMaxMana() {
        return role.getMaxMana(getLevel());
    }

    @Override
    public float getAttack() {
        return role.getAttack(getLevel());
    }

    @Override
    public float getDefence() {
        return role.getDefence(getLevel());
    }
    
}
