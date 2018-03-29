/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DerbyJavaDb;

import rpjava.server.dao.*;
import DerbyJavaDb.*;
import rpjava.server.AbstractFactoryDao;

/**
 *
 * @author doude
 */
public class FactoryDaoDerby implements AbstractFactoryDao {

    @Override
    public AccountDAO createAccountDao() {
        return new AccountDaoDerby();
    }
    
    @Override
    public NpcDAO createNpcDao(){
        return new NpcDaoDerby();
    }
    
    @Override
    public MapDAO createMapDao(){
        return null;
    }
}
