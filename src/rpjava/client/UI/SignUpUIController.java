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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import rpjava.client.RPJClient;
import rpjava.client.UIIF;
import rpjava.common.Account;
import rpjava.common.User;
import rpjava.common.exception.InvalidAccountException;
import rpjava.common.wrappers.AccountQuery;

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
    
    @FXML
    private TextField ageTF;
    
    @FXML
    private TextField nickNameTF;
    
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
    
    @FXML
    public void sendButton()
    {
        try
        {
            Account acc = new Account(loginTF.textProperty().get(), passwordTF.textProperty().get());
            User u = new User(nickNameTF.textProperty().get(), Integer.parseInt(ageTF.textProperty().get()), 0);
            Object o[] = {acc,u};
            AccountQuery signUpQuery = new AccountQuery(o, AccountQuery.QueryType.SIGNUP);
            client.sendToServer(signUpQuery);
        }
        catch(ClassCastException e)
        {
            message = "Age can only be a number";
        }
        catch(IOException e)
        {
            message = "An error has occured with the server";
        }
        catch(Exception e)
        {
            message = "Unknow error occured";
        }
        finally
        {
                /*final Stage dialog = new Stage();
                dialog.initModality(Modality.WINDOW_MODAL);
                dialog.initOwner(mainApp.getStage());
                VBox dialogVbox = new VBox(5);
                System.out.println(message);
                dialogVbox.getChildren().add(new Label(message));
                Button b = new Button("ok");
                b.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        mainApp.showLoginUI();
                        dialog.hide();
                    }
                });
                dialogVbox.getChildren().add(b);
                Scene dialogScene = new Scene(dialogVbox, 300, 200);
                dialog.setScene(dialogScene);*/
                
                
                //dialog.show();    
                mainApp.showLoginUI();
        }
        
    }
    
    
    
    
    
    
    
}
