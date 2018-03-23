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
import rpjava.client.LoginIF;
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
public class LoginUIController implements Initializable,LoginIF {
    
    @FXML
    private TextField loginTextField;
    
    @FXML
    private TextField passwordTextField;
    
    @FXML
    private Button signInButton;
    
    @FXML
    private Label SignUpLabel;
    
    @FXML
    private Label forgetPassLabel;
    
    //Reference to the main app
    private RPJavaMainApp mainApp;
    
    private RPJClient client;
    
    //The constructor
    public LoginUIController()
    {
       
        
    }
    
    public void initConnectioToServer(String host, int port)
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
    
    @Override
    public void receiveUserData(User u) {
        System.out.println(u.getNickName());
    }

    @Override
    public void InvalidLogin(InvalidAccountException e) {
        System.out.println("Login Invalid");
    }

    @Override
    public void connectionException(Exception e) {
        System.out.println(e.getMessage());
    }
    
}
