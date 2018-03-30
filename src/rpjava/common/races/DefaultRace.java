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
public class DefaultRace extends Race {

    public DefaultRace(){
        super(1,1,1,1);
    }
    
    @Override
    public String getRoleName() {
        return "Default race";
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
