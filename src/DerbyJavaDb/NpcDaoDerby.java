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
 * This class regroups all the access to Non-Playable Characters data persistence.
 * @author RPJavaTeam
 */
public class NpcDaoDerby implements NpcDAO {

    /**
     * Property that will contain the connection to the Database.
     * Will be constructed with a fellow method.
     * 
     * @see DbConnection#DbConnection()
     */ 
    private Connection con = DbConnection.getInstance();
    
    /**
     * This method allows you to get all the NPCs linked to a User.
     * @param userID The User identifier
     * @return NPC[] A vector of NPCs objects
     * @throws SQLException If an error occured, connection to the database failed
     */ 
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
    /**
     * This method allows an User to create a new NPC.
     * @param userID The User identifier
     * @param npc The new NPC to add
     * @return Boolean True if the new NPC is added to the User list, else False
     * @throws SQLException If an error occured, connection to the database failed
     */ 
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

        /**
     * This method allows an User to update a new NPC.
     * @param userID The User identifier
     * @param oldValue The current NPC before changes
     * @param newValue The new values of the NPC
     * @return Boolean True if the new NPC is changed, else False
     * @throws SQLException If an error occured, connection to the database failed
     */ 
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
   /**
     * This method allows an User to delete one of his NPC.
     * @param userID The User identifier
     * @param npc The NPC to delete
     * @return Boolean True if the new NPC is correctly deleteded, else False
     * @throws SQLException If an error occured, connection to the database failed
     */ 
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
