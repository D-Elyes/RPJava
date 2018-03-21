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
 *
 * @author Florent BERLAND
 */
public class Account implements Serializable {
    
    private StringProperty login, password;
    
    public Account(String login, String password) {
        this.login = new SimpleStringProperty(login);
        this.password = new SimpleStringProperty(password);
    }

    //Getter et setter of property value
    public String getLogin() {
        return login.get();
    }

    public void setLogin(String login) {
        this.login.set(login);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }
    
    //getter and setter of properties
    public StringProperty loginProperty()
    {
        return login;
    }
    
    public StringProperty passwordProperty()
    {
        return password;
    }
    
}
