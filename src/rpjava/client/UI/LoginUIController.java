/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.client.UI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import rpjava.client.UIIF;
import rpjava.client.RPJClient;
import rpjava.common.Account;
import rpjava.common.User;
import rpjava.common.exception.InvalidAccountException;
import rpjava.common.wrappers.AccountQuery;

/**
 * This class is the controller that manages The Login interface
 * @author RPJavaTeam
 * @version 1.0
 */
public class LoginUIController implements Initializable,UIIF {

    
// INSTANCE PROPERTIES ---------------------------------------------------------
    
    /**
    * Property FXML that contains the login textfield
    */
    private TextField loginTextField;
    
    /**
    * Property FXML that contains the password textfield
    */
    private TextField passwordTextField;
    
    
    /**
    * Property FXML that contains the signup label
    */
    private Label SignUpLabel;
    
    /**
    * Property FXML that contains the forget password textfield
    */
    private Label forgetPassLabel;
    
    /**
    * Property that contains the reference to the main application
    */
    private RPJavaMainApp mainApp;
    
    /**
    * Property that contains the reference to the linked client
    */
    private RPJClient client;

// CONSTRUCTOR -----------------------------------------------------------------
    
    /**
    * This method constructs a LoginUIController instance
    * @param host The host which will hold the connection
    * @param port The port the connection has to listen
    */
    public LoginUIController(String host, int port)
    {
       
        try
        {
            client = new RPJClient(host, port, this);
             client.openConnection();
        }
        catch(IOException e)
        {
               System.out.println(e.getMessage());
        }
        
        
    }
    
    /*public void initConnectioToServer(String host, int port)
    {
        
         try
        {
            client = new RPJClient(host, port, this);
             client.openConnection();
        }
        catch(IOException e)
        {
               System.out.println(e.getMessage());
        }
    }*/
    
    

    /**
     * This method initializes the controller class. To complete
     * @param url 
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    /**
     * This method is called by the main application to give a reference back to itself
     * @param mainApp 
     */
    public void setRPJavaMainApp(RPJavaMainApp mainApp)
    {
        this.mainApp = mainApp;
        
        
    }
    
    /**
     * This method is called when the user clicks on the sign in button
     */
    
    @FXML
    private void handleSingIn()
    {
        
        Account acc = new Account(loginTextField.getText(), passwordTextField.getText());
        AccountQuery accQuery = new AccountQuery(acc, AccountQuery.QueryType.SIGNIN);
        try
        {   
            client.sendToServer(accQuery);
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        catch (Exception e)
        {
          
            System.out.println(e.getMessage());
        }
        
        
    }
    
    /**
    * This method displays the nickname of the connecting user.
    * @param u The connecting user
    */
    public void receiveUserData(User u) {
        System.out.println(u.getNickName());
    }

     /**
    * This method displays an error message when the login is invalid.
    * @param e An invalid account error
    */
    public void invalidLogin(InvalidAccountException e) {
        System.out.println("Invalid Login");
    }

     /**
    * This method displays an error message when an exception occurs.
    * @param e An exception
    */
    public void connectionException(Exception e) {
        System.out.println(e.getMessage());
    }
    
     /**
    * This method tells to the current class how to treat a receiving message.
    * @param msg The receiving message
    */
    @Override
    public void handleMessage(Object msg) {
        if(msg instanceof InvalidAccountException){
            invalidLogin((InvalidAccountException)msg);
        } else if(msg instanceof Exception){
            connectionException((Exception)msg);
        } else if(msg instanceof User){
            receiveUserData((User)msg);
        } else {
            System.out.println("Error : object " + msg.getClass().getName() + " not valid for the login");
        }
    }
}
