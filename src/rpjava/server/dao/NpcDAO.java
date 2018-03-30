/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.server.dao;

import java.sql.SQLException;
import rpjava.common.*;

/**
 *
 * @author Florent BERLAND
 */
public interface NpcDAO {
    
    public NPC[] getNpcs(int userID) throws SQLException;
    public boolean addNpc(int userID, NPC npc) throws SQLException;
    public boolean updateNpc(int userID, NPC oldValue, NPC newValue) throws SQLException;
    public boolean deleteNpc(int userID, NPC npc) throws SQLException;
}
