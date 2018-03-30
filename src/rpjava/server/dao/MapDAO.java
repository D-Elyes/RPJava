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
public interface MapDAO {
    
    public Map[] getMapsHeader(int userID) throws SQLException;
    public Map loadMap(int mapID) throws SQLException;
    public boolean addMap(int userID, Map map) throws SQLException;
    public boolean updateMap(int mapID, Map newValue) throws SQLException;
    public boolean deleteMap(int mapID) throws SQLException;
    
}
