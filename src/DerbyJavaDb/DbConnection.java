/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DerbyJavaDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class will handle the connection to the database.
 * It will open a connection once when the application begin to run.
 * @author RPJavaTeam
 */
public class DbConnection {
    
     /**
     * Property that will contain the connection to the Database.
     * Will be constructed with a fellow method.
     * 
     * @see DbConnection#DbConnection()
     */ 
    private static Connection con = null; 
    
    /**
     * Property that will contain the url to the Database
     */ 
    private static final String Url = "jdbc:derby://localhost:1527/RPJavaDb"; 
    
    /**
     * Property that will contain the login to the Database
     */ 
    private static final String User = "RPJava"; 
    
    /**
     * Property that will contain the password to the DFatabase
     */ 
    private static final String Password = "123456"; //the password of the database
    
     /**
     * This method will allow you to construct an instance of the class.
     * We openn a connection. If any error occurs, then an error message is displayed.
     */ 
    private DbConnection()
    {
        try
        {
            con = DriverManager.getConnection(Url,User,Password);
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * This method returns th current properties of thedatabase connection.
     * If it does not exist, then we create a nex connection.
     */ 
    public static Connection getInstance()
    {
        if(con == null)
           new DbConnection();
        
        return con;
    }
    
    
    
    
}
