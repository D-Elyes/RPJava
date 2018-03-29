
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
import rpjava.server.dao.AccountDAO;

/**
 * This classe allows you to manage the system of Account in the Derby Java DDatabase.
 * @author RPJavaTeam
 * @version 1.0
 */
public class AccountDaoDerby implements AccountDAO {

// INSTANCE VARIABLES ***********************************************
     
    /**
      * Creation of the connection to Database. Can't be changed.
     */ 
    private Connection con = DbConnection.getInstance();
    
    
    
// INSTANCE METHODS ***********************************************
    
    
    /**
     * This method will handle the connection to the server.
     * @param account The account used to sign in (composed of a login and a password)
     * @return User If the login and password correspond in the database
     * @throws SQLException If an error occured, connection to the database failed
     */ 
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
            
        
        
        User user = new User(resUser.getString("NICKNAME"), resUser.getInt("AGE"), resUser.getInt("IDUSER"));
         
        return user;
                  
        
        
    }

    /**
     * This method will handle the creation of an account
     * @param account The account used to sign up (composed of a login and a password)
     * @param user The user who wants to create its account
     * @return Boolean True if the signing up succeeded, false else
     * @throws SQLException If an error occured, connection to the database failed
     */ 
    @Override
    public Boolean signUp(Account account, User user) throws SQLException {
        String checkExistingAccount = "SELECT * FROM ACCOUNT WHERE LOGIN = '" + account.getLogin() + "';";
        ResultSet existing = con.createStatement().executeQuery(checkExistingAccount);
        if (!existing.next()) { return false; }
        
        String addAccount = "INSERT INTO ACCOUNT (LOGIN,PASSWORD) VALUES ('"
                + account.getLogin() + "','"
                + account.getPassword() + "');";
        con.createStatement().execute(addAccount);
        
        String addUser = "INSERT INTO USERS (NICKNAME, AGE, IDACCOUNT) VALUES ('"
                + user.getNickName() + "',"
                + user.getAge()
                + ",(SELECT IDACCOUNT FROM ACCOUNT WHERE LOGIN = '" + account.getLogin() + "'));";
        con.createStatement().execute(addUser);
        return true;
    }
    
    
    /**
     * This method will handle the update of an account.
     * @param oldValue The current account values
     * @param newValue The new account values
     * @return Boolean True if the update succeeded, false else
     * @throws SQLException If an error occured, connection to the database failed
     */ 
    
    @Override
    public Boolean updateAccount(Account oldValue, Account newValue) throws SQLException {
        String checkUser = "SELECT * FROM ACCOUNT WHERE LOGIN = '" + oldValue.getLogin() + "';";
        ResultSet res = con.createStatement().executeQuery(checkUser);
        if (!res.next()) { return false; }
        
        String updateUser = "UPDATE ACCOUNT SET LOGIN = '" + newValue.getLogin() 
                + "', PASSWORD = '" + newValue.getPassword()
                + "' WHERE LOGIN = '" + oldValue.getLogin()
                + "' AND PASSWORD = '" + oldValue.getPassword() + "';";
        con.createStatement().execute(updateUser);
        return true;
    }

 /**
     * This method will handle the deletion of an account.
     * Currently, this method is not implemented.
     * @param account The account which has to be deleted
     * @return Boolean True if the deletion succeeded, false else
     * @throws SQLException If an error occured, connection to the database failed
     */ 

    @Override
    public Boolean deleteAccout(Account account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
