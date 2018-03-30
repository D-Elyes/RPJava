/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.common.races;

import rpjava.common.Race;

/**
 *
 * @author Florent BERLAND
 */
public class Human extends Race{
    
    public Human() {
        super(105, 90, 1.15f, 1.1f);
    }
    
    @Override
    public String getRaceName() {
        return "Human";
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
