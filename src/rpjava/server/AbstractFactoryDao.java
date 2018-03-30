/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.server;

import rpjava.server.dao.*;

/**
 *
 * @author doude
 */
public interface AbstractFactoryDao {
    
    public AccountDAO createAccountDao();
    public NpcDAO createNpcDao();
    public MapDAO createMapDao();
}
