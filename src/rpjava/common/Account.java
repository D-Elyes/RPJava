/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.common;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

/**
 * This class gathers all informations about accounts
 * @author RPJavaTeam
 */
public class Account implements Serializable {
   
// INSTANCE PROPERTIES ---------------------------------------------------------
    
    /**
    * Properties that correspond to login and password
    */
    private String login, password;
    
// CONSTRUCTOR -----------------------------------------------------------------
    
    /**
    * This method constructs a new Account instance
    * @param login The login of the user
    * @param password The password of the user
    */
    public Account(String login, String password) {
        this.login = login;
        this.password =  password;
    }

// GETTERS AND SETTERS ---------------------------------------------------------
    
    /**
    * This method gets the login of the user
    * @return String The login of the current user
    */
    public String getLogin() {
        return login;
    }

    /**
    * This method change the login of the user
    * @param login The new login
    */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
    * This method gets the password of the user
    * @return String The password of the current user
    */
    public String getPassword() {
        return password;
    }

    /**
    * This method change the password of the user
    * @param password The new login
    */
    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
