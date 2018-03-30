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
public class Griffin extends Race {

    public Griffin() {
        super(80, 20, 1.3f, .9f);
    }

    @Override
    public String getRaceName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public int getMaxHp(int level) {
        return (int)Math.pow(level, .27)*this.getBaseHP();
    }

    @Override
    public int getMaxMana(int level) {
        return (int)Math.pow(level, .9)*this.getBaseMana();
    }

    @Override
    public float getAttack(int level) {
        return (int)Math.pow(level, .15)*this.getBaseAttack();
    }

    @Override
    public float getDefence(int level) {
        return (int)Math.pow(level, .11)*this.getBaseDefence();
    }
    
}
