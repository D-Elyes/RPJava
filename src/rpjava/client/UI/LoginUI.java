/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.client.UI;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author doude
 */
public class LoginUI extends Parent {
    
    
    public LoginUI()
    {
        BorderPane pane = new BorderPane();
        
        Label logInLabel = new Label("Log in");
        Label passWordLabel = new Label("Password");
        
        TextField logInTextField = new TextField();
        TextField passwordTextField = new TextField();
        
        
        this.getChildren().add(pane);
    }
    
}
