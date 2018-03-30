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
public class Warrior extends Role {

    public Warrior() {
        super(120, 70, 1.3f, 1.2f);
    }

    @Override
    public String getRoleName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public int getMaxHp(int level) {
        return (int)Math.pow(level, .3)*this.getBaseHP();
    }

    @Override
    public int getMaxMana(int level) {
        return (int)Math.pow(level, .15)*this.getBaseMana();
    }

    @Override
    public float getAttack(int level) {
        return (int)Math.pow(level, .13)*this.getBaseAttack();
    }

    @Override
    public float getDefence(int level) {
        return (int)Math.pow(level, .13)*this.getBaseDefence();
    }
}
