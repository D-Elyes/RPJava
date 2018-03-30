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
        
        String req = "SELECT * FROM GENERICNPC WHERE USERID = " + userID + ";";
        
        ResultSet res = con.createStatement().executeQuery(req);
        
        Collection<NPC> col = new LinkedList<>();
        while(res.next()){
            NPC npc = new NPC(Race.createFromName(res.getString("RACE")), res.getString("NAME"),
                    res.getBoolean("ISAGRESSIVE"), res.getBoolean("ISBOSS"), res.getString("SPEECH"));
            npc.setLevel(res.getInt("DEFAULTLEVEL"));
            col.add(npc);
        }
        
        return (NPC[])col.toArray();
    }

    @Override
    public boolean addNpc(int userID, NPC npc) throws SQLException {
        
        String req = "INSERT INTO GENERICNPC (USERID, RACE, NAME, ISAGRESSIVE, ISBOSS, DEFAULTLEVEL, SPEECH) VALUES ("
                + userID + ","
                + "'" + npc.getRace().getClassName() + "',"
                + "'" + npc.getName() + "'," 
                + npc.isAgressive() + ","
                + npc.isBoss() + ","
                + npc.getLevel() + ",'"
                + npc.getSpeech() + "'"
                + ") WHERE USERID='"+userID+"';";
        
        return con.createStatement().execute(req);
    }

    @Override
    public boolean updateNpc(int userID, NPC oldValue, NPC newValue) throws SQLException {
        String req = "UPDATE GENERICNPC SET "
                + "NAME = '" + newValue.getName()
                + "', RACE = '" + newValue.getRace().getClassName()
                + "', ISAGRESSIVE = " + newValue.isAgressive()
                + ", ISBOSS = " + newValue.isBoss()
                + ", DEFAULTLEVEL = " + newValue.getLevel()
                + " SPEECH = '" + newValue.getSpeech()
                + "' WHERE IDUSER = " + userID
                + " AND NAME = '" + oldValue.getName()
                + "' AND RACE = '" + oldValue.getRace().getClassName()
                + "' AND ISAGRESSIVE = " + oldValue.isAgressive()
                + " AND ISBOSS = " + oldValue.isBoss()
                + " AND DEFAULTLEVEL = " + oldValue.getLevel()
                + " AND SPEECH = '" + oldValue.getSpeech() + "';";
        
        return con.createStatement().execute(req);
    }

    @Override
    public boolean deleteNpc(int userID, NPC npc) throws SQLException {
        
        String req = "DELETE FROM GENERICNPC WHERE USERID = " + userID
                + " AND NAME = '" + npc.getName()
                + "' AND RACE = '" + npc.getRace().getClassName()
                + "' AND ISAGRESSIVE = " + npc.isAgressive()
                + " AND ISBOSS = " + npc.isBoss()
                + " AND DEFAULTLEVEL = " + npc.getLevel()
                + " AND SPEECH = '" + npc.getSpeech() + "';";
        
        return con.createStatement().execute(req);
    }
    
}
