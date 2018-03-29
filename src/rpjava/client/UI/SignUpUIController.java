/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.client.UI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import rpjava.client.RPJClient;
import rpjava.client.UIIF;
import rpjava.common.User;
import rpjava.common.exception.InvalidAccountException;

/**
 * FXML Controller class
 *
 * @author doude
 */
public class SignUpUIController implements Initializable, UIIF {
    
    @FXML
    private TextField loginTF;
    
    @FXML
    private TextField passwordTF;
    
    @FXML
    private TextField confirmPassTF;
    
    @FXML
    private TextField emailTF;
    
     //Reference to the main app
    private RPJavaMainApp mainApp;
    
    //client responsible of the connection to the server
    private RPJClient client;
    private String message;
    
    
    public SignUpUIController(RPJClient client)
    {
        this.client = client;
    }
    
     /**
     * Is called by the main application  to give  a reference back to itself
     * @param mainApp 
     */
    public void setRPJavaMainApp(RPJavaMainApp mainApp)
    {
        this.mainApp = mainApp;
        
        
    }
            
         

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @Override
    public void handleMessage(Object msg) {
         if(msg instanceof InvalidAccountException)
         {
             message = "Login already used";
         }
           
        if(msg instanceof Exception)
        {
           message = "There was an error with the server";
        } 
        else if(msg instanceof User)
        {
            message = "Aaccount created succussfully";
        }
    }
    
    
    @FXML
    public void homeButton()
    {
        
        mainApp.showLoginUI();
    }
    
    
    
    
    
    
    
    
}
