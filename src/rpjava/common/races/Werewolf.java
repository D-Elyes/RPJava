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
public class Werewolf extends Race {
    
    public Werewolf() {
        super(90, 20, 1.5f, 1.1f);
    }
    
    @Override
    public String getRaceName() {
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
