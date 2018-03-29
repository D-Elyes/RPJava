/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.server.dao;

import java.sql.SQLException;
import rpjava.common.Player;

/**
 *
 * @author Florent BERLAND
 */
public interface CharacterDAO {
    
    public Player[] getCharacters(int userID) throws SQLException;
    public boolean addCharacter(int userID, Player player) throws SQLException;
    public boolean updateCharacter(int userID, Player oldValue, Player newValue) throws SQLException;
    public boolean deleteCharacter(int userID, Player player) throws SQLException;
    
}
