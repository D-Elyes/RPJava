/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DerbyJavaDb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import rpjava.common.Account;
import rpjava.common.User;

/**
 *
 * @author doude
 */
public class AccountDaoDerby implements AccountDAO {

    private Connection con = DbConnection.getInstance();
    //This method will handle the connection to the server
    //It will return a User if the login succeed, else return null
    @Override
    public User signIn(Account account) throws SQLException
    {
        String req = "SELECT * FROM ACCOUNT WHERE LOGIN='"+account.getLogin()+"' AND PASSWORD='"+account.getPassword()+"'";
        
        ResultSet res = con.createStatement().executeQuery(req);
       
        if(res.next() == false)
        {
            
            return null;
        }
       
         
        String reqUser = "SELECT * FROM USERS u WHERE u.IDACCOUNT="+res.getInt("IDACCOUNT");
        
        ResultSet resUser = con.createStatement().executeQuery(reqUser);
        
        if(resUser.next() == false)
        {
            
            return null;
        }
            
        
        User user = new User(resUser.getString("NICKNAME"), resUser.getInt("AGE"));
         
        return user;
                  
        
        
    }

    //This method will handle the creation of account
    //It will return true if the creation succeed, else false
    @Override
    public Boolean signUp(Account account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //This method will handle the update of an account
    ///It returns true if the update succeed, else false
    @Override
    public Boolean updateAccount(Account oldValue, Account newValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //This methos will handle the delete of an account
    //it will return false if the delete fails, else true
    @Override
    public Boolean deleteAccout(Account account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
