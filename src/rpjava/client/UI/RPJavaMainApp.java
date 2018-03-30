
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.client.UI;

import java.io.IOException;
import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import rpjava.client.RPJClient;
import rpjava.common.User;

/**
 * This class is the main RPJava mais class of the app
 * @author RPJavaTeam
 */
public class RPJavaMainApp extends Application {
   
// INSTANCE PROPERTIES ---------------------------------------------------------
    
    /**
    * Property that contains the host 
    */
    private String host = "localhost";
    
    private RPJClient client;
    private User user;
    
    /**
    * Property that contains the port 
    */
    private int port = 12345;
    
     /**
    * Property that will contains the primary stage of the main application 
    */
    private Stage primaryStage;
    

// INSTANCE METHODS ------------------------------------------------------------
    
    /**
    * This is the starting method call at the running time
    * @param primaryStage The first windows to display
    */
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("RPJava");
        this.primaryStage.setResizable(false);
        
        user = null;
        client = new RPJClient(host, port);
        try
        {
              client.openConnection();
        
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        
        showLoginUI();
       
    }
    
    /**
     * Show the login UI inside the rootLayout
     */
    public void showLoginUI()
    {
        try
        {
             
            FXMLLoader loader = new FXMLLoader();
            
            LoginUIController controller =  new LoginUIController(client);
            
            loader.setLocation(RPJavaMainApp.class.getResource("LoginUI.fxml"));
            loader.setController(controller);
            AnchorPane loginUI = (AnchorPane) loader.load();
            
            client.setUI(controller);       
           
           controller.setRPJavaMainApp(this);
            
            Scene logInScene = new Scene(loginUI);
            primaryStage.setScene(logInScene);
            primaryStage.show();
            
           
        }
        catch(IOException e)
        {
            System.out.println("In the login UI init");
            System.out.println(e.getMessage());
            e.printStackTrace();   

    
        }
    }
    
    public void showSignUpUI()
    {
         try
        {
             
            FXMLLoader loader = new FXMLLoader();
           
            SignUpUIController controller = new SignUpUIController(client);
            loader.setLocation(RPJavaMainApp.class.getResource("SignUpUI.fxml"));
            loader.setController(controller);
            AnchorPane signUpUI = (AnchorPane) loader.load();
            client.setUI(controller);
           controller.setRPJavaMainApp(this);
            
            Scene signUpScene = new Scene(signUpUI);
            primaryStage.setScene(signUpScene);
            primaryStage.show();
            
            
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();   
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void showRecoveryPasswordUI()
    {
         try
        {
             RecoveryPasswordUIController controller = new RecoveryPasswordUIController(client);
            FXMLLoader loader = new FXMLLoader();
            
            loader.setLocation(RPJavaMainApp.class.getResource("RecoveryPasswordUI.fxml"));
            loader.setController(controller);
            AnchorPane recoveryPassui = (AnchorPane) loader.load();
            
           controller.setRPJavaMainApp(this);
            
            Scene recoveryPassScene = new Scene(recoveryPassui);
            primaryStage.setScene(recoveryPassScene);
            primaryStage.show();
            
           
        }
        catch(IOException e)
        {
           // System.out.println(e.getMessage());
            e.printStackTrace();   
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void showManiMenuUI()
    {
        try
        {
             MainMenuUIController controller = new MainMenuUIController(client);
            FXMLLoader loader = new FXMLLoader();
            
            loader.setLocation(RPJavaMainApp.class.getResource("MainMenuUI.fxml"));
            loader.setController(controller);
            AnchorPane mainMenu = (AnchorPane) loader.load();
            
           controller.setRPJavaMainApp(this);
            
            Scene mainMenuScene = new Scene(mainMenu);
            primaryStage.setScene(mainMenuScene);
            primaryStage.show();

        }
        catch(IOException e)
        {
           // System.out.println(e.getMessage());
            e.printStackTrace();   
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    
    public void showNpcManageUI()
    {
         try
        {
             NpcManageUIController controller = new NpcManageUIController(client);
            FXMLLoader loader = new FXMLLoader();
            
            loader.setLocation(RPJavaMainApp.class.getResource("NpcManageUI.fxml"));
            loader.setController(controller);
            AnchorPane npcUI = (AnchorPane) loader.load();
            
           controller.setRPJavaMainApp(this);
            
            Scene npcScene = new Scene(npcUI);
            primaryStage.setScene(npcScene);
            primaryStage.show();
            
           
        }
        catch(IOException e)
        {
           // System.out.println(e.getMessage());
            System.out.println(e.getMessage());
            e.printStackTrace();   
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

   
    /**
     * This getter return the main stage
     * @return Stage The main stage
     */    public Stage getStage()
    {
        return primaryStage;
    }
    

    /**
<<<<<<< HEAD
=======
     * Main méthod launching the class
>>>>>>> 6e928da212e6a42e357f1290491873993255fafd
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    

    
}
