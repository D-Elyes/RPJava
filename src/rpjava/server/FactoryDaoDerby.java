/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.server;

import rpjava.server.dao.*;
import DerbyJavaDb.*;

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
    
}
