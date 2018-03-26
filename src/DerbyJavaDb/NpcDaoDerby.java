/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DerbyJavaDb;

import java.sql.Connection;
import java.sql.SQLException;
import rpjava.common.*;
import rpjava.server.dao.*;

/**
 *
 * @author Florent BERLAND
 */
public class NpcDaoDerby implements NpcDAO {

    private Connection con = DbConnection.getInstance();
    
    @Override
    public NPC[] getNpcs(int userID) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addNpc(int userID, NPC npc) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateNpc(int userID, NPC oldValue, NPC newValue) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteNpc(int userID, NPC npc) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
