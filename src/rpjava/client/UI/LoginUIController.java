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
    public LoginUIController(RPJClient client)
    {
        
       
           this.client = client;
        
        
        
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
    private  void handleSingIn()
    {
        
        Account acc = new Account(loginTextField.getText(), passwordTextField.getText());
        AccountQuery accQuery = new AccountQuery(acc, AccountQuery.QueryType.SIGNIN);
         try
        { 
            
                        client.sendToServer(accQuery);
                       for (long i = 0; i < 1e5; i++) {
                
            }
            
               
          
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
        
        if(mainApp.getUser() != null)
                    mainApp.showManiMenuUI();
        
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
