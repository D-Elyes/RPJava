/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.client.UI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
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
    @FXML
    private TextField loginTextField;
    
    /**
    * Property FXML that contains the password textfield
    */
    @FXML
    private TextField passwordTextField;
    
    

    /**
    * Property FXML that contains the signup label
    */
    @FXML
    private Label SignUpLabel;
    
    /**
    * Property FXML that contains the forget password textfield
    */
    @FXML
    private Label forgetPassLabel;
    
    /**
    * Property that contains the reference to the main application
    */
    
    private RPJavaMainApp mainApp;
    
    /**
    * Property that contains the reference to the linked client
    */
    private RPJClient client;
    //The constructor
// CONSTRUCTOR -----------------------------------------------------------------
    
    /**
    * This method constructs a LoginUIController instance
    * @param host The host which will hold the connection
    * @param port The port the connection has to listen
    */
    public LoginUIController(RPJClient client)

    {
        
       
           this.client = client;
        
        
        
    }
    
  

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
                     
            
               
          
            if(mainApp.getUser() != null)
                mainApp.showManiMenuUI();

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
    public void handleSignUpLabel()
    {
        
        mainApp.showSignUpUI();
        
    }
    
    @FXML
    public void handleForgetPassword()
    {
        mainApp.showRecoveryPasswordUI();
    }
    
    
    public  void  receiveUserData(User u) {
        
            mainApp.setUser(u);
            //notifyAll();
    }
     /**
    * This method displays an error message when the login is invalid.
    * @param e An invalid account error
    */
    public void invalidLogin(InvalidAccountException e) {
       System.out.println("Login Invalid");
        /*final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
                dialog.initOwner(mainApp.getStage());
                VBox dialogVbox = new VBox(20);
                dialogVbox.getChildren().add(new Text("Invalid Account"));
                Scene dialogScene = new Scene(dialogVbox, 300, 200);
                dialog.setScene(dialogScene);
                dialog.show();    */

    }

     /**
    * This method displays an error message when an exception occurs.
    * @param e An exception
    */
    public void connectionException(Exception e) {
        /* final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
                dialog.initOwner(mainApp.getStage());
                VBox dialogVbox = new VBox(20);
                dialogVbox.getChildren().add(new Text("server Error !!!!!!!!!"));
                Scene dialogScene = new Scene(dialogVbox, 300, 200);
                dialog.setScene(dialogScene);
                dialog.show();    
                mainApp.showLoginUI();*/
        System.out.println("Error Connection");
        //System.out.println(e.getMessage());
    }
    
    public void closeButton()
    {
        System.exit(0);
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
