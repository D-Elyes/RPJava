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
 *
 * @author doude
 * This class will handle the connection to the database
 * It will open a conncetion once when the application begin to run
 * 
 */
public class DbConnection {
    
    private static Connection con = null; // the property that will contain the connection
    private static final String Url = "jdbc:derby://localhost:1527/RPJavaDb"; //the url of the database
    private static final String User = "RPJava"; //the login for the database
    private static final String Password = "123456"; //the password of the database
    
    //THe constructor of the class
    //We open a conncetion, if there is any error it will display an error message
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
    
    //la methode qui retourne la connection
    public static Connection getInstance()
    {
        if(con == null)
           new DbConnection();
        
        return con;
    }
    
    
    
    
}
