/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.common.roles;

import rpjava.common.Role;

/**
 *
 * @author Florent BERLAND
 */
public class DefaultRole extends Role{
    
    public DefaultRole() {
        super(100, 100, 1f, 1f);
    }

    @Override
    public String getRoleName() {
        return "Default role";
    }

    @Override
    public int getMaxHp(int level) {
        return (int)(1+level/10f)*this.getBaseHP();
    }

    @Override
    public int getMaxMana(int level) {
        return (int)(1+level/5f)*this.getBaseMana();
    }

    @Override
    public float getAttack(int level) {
        return (int)(1+level/20f)*this.getBaseAttack();
    }

    @Override
    public float getDefence(int level) {
        return (int)(1+level/100f)*this.getBaseDefence();
    }
}
