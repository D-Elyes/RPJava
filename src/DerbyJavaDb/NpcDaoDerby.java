/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DerbyJavaDb;

import java.sql.*;
import rpjava.common.*;
import rpjava.server.dao.*;
import java.util.*;

/**
 *
 * @author Florent BERLAND
 */
public class NpcDaoDerby implements NpcDAO {

    private Connection con = DbConnection.getInstance();
    
    @Override
    public NPC[] getNpcs(int userID) throws SQLException {
        
        String req = "SELECT * FROM GENERICNPC WHERE USERID='"+userID+"'";
        
        ResultSet res = con.createStatement().executeQuery(req);
        
        Collection<NPC> col = new LinkedList<>();
        while(res.next()){
            NPC npc = new NPC(Race.createFromName("RACE"), res.getString("NAME"), res.getBoolean("ISBOSS"), res.getBoolean("ISAGRESSIVE"));
            col.add(npc);
        }
        
        return (NPC[])col.toArray();
    }

    @Override
    public boolean addNpc(int userID, NPC npc) throws SQLException {
        
        String req = "INSERT INTO GENERICNPC (USERID, RACE, NAME, ISAGRESSIVE, ISBOSS, DEFAULTLEVEL) VALUES ("
                + userID + ","
                + "'" + npc.getRace().getClassName() + "',"
                + "'" + npc.getName() + "'," 
                + npc.isAgressive() + ","
                + npc.isBoss() + ","
                + npc.getLevel() + ","
                + ") WHERE USERID='"+userID+"'";
        
        ResultSet res = con.createStatement().executeQuery(req);
        
        return true;
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
