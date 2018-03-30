/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.server.dao;

import java.sql.SQLException;
import rpjava.common.Account;
import rpjava.common.User;

/**
 *
 * @author doude
 */
public interface  AccountDAO {
    
    public abstract User signIn(Account account) throws SQLException;
    public abstract Boolean signUp(Account account, User user) throws SQLException;
    public abstract Boolean updateAccount(Account oldValue, Account newValue) throws SQLException;
    public abstract Boolean deleteAccout(Account account) throws SQLException;
    
    
}
