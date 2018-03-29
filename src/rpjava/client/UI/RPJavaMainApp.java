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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import rpjava.client.RPJClient;
import rpjava.common.User;

/**
 *
 * @author doude
 */
public class RPJavaMainApp extends Application {
    
    final private  String host = "localhost";
    final private int port = 12345;
    private RPJClient client;
    
    
    private Stage primaryStage;
    private BorderPane rootLayout;
    
    @Override
    public void start(Stage primaryStage)  {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("RPJava");
        this.primaryStage.setResizable(false);
        
        client = new RPJClient(host, port);
        try
        {
              client.openConnection();
        
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
      
       // initRootLayout();
        
        showLoginUI();
       
    }
    
    /**
     * Initilize the root layout
     */
  /* public void initRootLayout()
    {
        try
        {
            //load from fxml file
            FXMLLoader loader = new FXMLLoader();
           
            loader.setLocation(RPJavaMainApp.class.getResource("RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            
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
    }*/
    
    
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
            
            
          
            
           // rootLayout.setCenter(loginUI);
            
            
            //give the controller access to the main app
            
           
            //LoginUIController controller = loader.getController();
            
           // controller.initConnectioToServer(host,port);
            

            //loader.setController(controller);
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
        catch(Exception e)
        {
            System.out.println(e.getMessage());
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
    
    public void showManiMenuUI(User user)
    {
        try
        {
             MainMenuUIController controller = new MainMenuUIController(client,user);
            FXMLLoader loader = new FXMLLoader();
            
            loader.setLocation(RPJavaMainApp.class.getResource("MainMenuUI.fxml"));
            loader.setController(controller);
            AnchorPane recoveryPassui = (AnchorPane) loader.load();
            
           controller.setRPJavaMainApp(this);
            
            Scene mainMenuScene = new Scene(recoveryPassui);
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
    /**
     * Return the main stage
     */
    public Stage getStage()
    {
        return primaryStage;
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
