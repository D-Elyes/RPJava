/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DerbyJavaDb;

import java.sql.*;
import rpjava.common.Map;
import rpjava.server.dao.MapDAO;
import java.util.*;
import rpjava.common.Room;

/**
 *
 * @author Florent BERLAND
 */
public class MapDaoDerby implements MapDAO {

    private Connection con = DbConnection.getInstance();
    
    @Override
    public Map[] getMapsHeader(int userID) throws SQLException {
        
        String req = "SELECT * FROM MAP WHERE IDUSER = '" + userID + "';";
        ResultSet res = con.createStatement().executeQuery(req);
        
        Collection<Map> maps = new HashSet<>();
        while(res.next()){
            maps.add(new Map(res.getInt("IDMAP"), res.getNString("NAME")));
        }
        
        return (Map[])maps.toArray();
    }

    @Override
    public Map loadMap(int mapID) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addMap(int userID, Map map) throws SQLException {
       String testUser = "SELECT * FROM USERS WHERE IDUSER = " + userID + ";";
       ResultSet test = con.createStatement().executeQuery(testUser);
       if (!test.next()) { return false; }
       
       String reqMap = "INSERT INTO MAP (NAME, IDUSER) VALUES ('" + map.getName() + "', " + userID + ");";
       con.createStatement().execute(reqMap);
       
       for(Room r : map.getRooms()){
           addRoom(r, map.getId());
       }
       
       return true;
    }

    @Override
    public boolean updateMap(int mapID, Map newValue) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteMap(int mapID) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  
    
    private void addRoom(Room r, int idMap){
        
    }
    
}
