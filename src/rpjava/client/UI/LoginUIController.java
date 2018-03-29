/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.client.UI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import rpjava.client.UIIF;
import rpjava.client.RPJClient;
import rpjava.common.Account;
import rpjava.common.User;
import rpjava.common.exception.InvalidAccountException;
import rpjava.common.wrappers.AccountQuery;

/**
 * FXML Controller class
 *
 * @author doude
 */
public class LoginUIController implements Initializable,UIIF {
    
    @FXML
    private TextField loginTextField;
    
    @FXML
    private TextField passwordTextField;
    
    
    @FXML
    private Label signUpLabel;
    
    @FXML
    private Label forgetPassLabel;
    
    //Reference to the main app
    private RPJavaMainApp mainApp;
    
    private RPJClient client;
    
    //The constructor
    public LoginUIController(String host, int port)
    {
        signUpLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               handleSignUp();
            }
        });
       
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
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
     * Called when the user click on the Sing in button
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
    
    @FXML
    public void handleSignUp()
    {
        SignUpUIController signUpUiController = new SignUpUIController(client);
        mainApp.showSignUpUI(signUpUiController);
        
    }
    
    
    public void receiveUserData(User u) {
        System.out.println(u.getNickName());
    }

    public void invalidLogin(InvalidAccountException e) {
        System.out.println("Login Invalid");
    }

    public void connectionException(Exception e) {
        System.out.println(e.getMessage());
    }
    
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
