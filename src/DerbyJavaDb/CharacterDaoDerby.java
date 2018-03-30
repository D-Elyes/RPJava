/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DerbyJavaDb;

import java.sql.*;
import rpjava.common.Player;
import rpjava.server.dao.CharacterDAO;
import java.util.*;
import rpjava.common.Role;

/**
 *
 * @author Florent BERLAND
 */
public class CharacterDaoDerby implements CharacterDAO {

    private Connection con = DbConnection.getInstance();
    
    @Override
    public Player[] getCharacters(int userID) throws SQLException {
        
        String req = "SELECT * FROM PLAYABLECHAR WHERE IDUSER = " + userID + ";";
        ResultSet res = con.createStatement().executeQuery(req);
        
        Collection<Player> col = new HashSet<>();
        while(res.next()){
            Player player = new Player(null, Role.createFromName(res.getString("ROLE")), res.getString("NAME"), res.getInt("INVSIZE"));
            player.setXp(res.getFloat("XP"));
            col.add(player);
        }
        
        return (Player[])col.toArray();
    }

    @Override
    public boolean addCharacter(int userID, Player player) throws SQLException {
        
        String reqTest = "SELECT * FROM USERS WHERE IDUSER = " + userID + ";";
        ResultSet res = con.createStatement().executeQuery(reqTest);
        if(!res.next()){ return false; }
        
        String addReq = "INSERT INTO PLAYABLECHAR (NAME, ROLE, XP, IDUSER, INVSIZE) VALUES ('"
                + player.getName()
                + "', '" + player.getRole().getClassName()
                + "', " + player.getXp()
                + ", " + userID
                + ", " + player.getInventory().getSize() + ");";
        return con.createStatement().execute(addReq);
    }

    @Override
    public boolean updateCharacter(int userID, Player oldValue, Player newValue) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteCharacter(int userID, Player player) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
