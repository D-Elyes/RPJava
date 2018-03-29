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

/**
 *
 * @author doude
 */
public class RPJavaMainApp extends Application {
    
    private String host = "localhost";
    private int port = 12345;
    
    private Stage primaryStage;
    private BorderPane rootLayout;
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("RPJava");
        this.primaryStage.setResizable(false);
        
        initRootLayout();
        
        showLoginUI();
       
    }
    
    /**
     * Initilize the root layout
     */
    public void initRootLayout()
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
    }
    
    
    /**
     * Show the login UI inside the rootLayout
     */
    public void showLoginUI()
    {
        try
        {
             
            FXMLLoader loader = new FXMLLoader();
            LoginUIController controller =  new LoginUIController(host, port);
            loader.setLocation(RPJavaMainApp.class.getResource("LoginUI.fxml"));
            loader.setController(controller);
            AnchorPane loginUI = (AnchorPane) loader.load();
            
            
            rootLayout.setCenter(loginUI);
            
            
            //give the controller access to the main app
            
           
            //LoginUIController controller = loader.getController();
            
           // controller.initConnectioToServer(host,port);
            

            //loader.setController(controller);
            controller.setRPJavaMainApp(this);
            
           
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
    
    public void showSignUpUI(SignUpUIController controller)
    {
         try
        {
             
            FXMLLoader loader = new FXMLLoader();
            
            loader.setLocation(RPJavaMainApp.class.getResource("SignUpUI.fxml"));
            loader.setController(controller);
            AnchorPane signUpUI = (AnchorPane) loader.load();
            
           // primaryStage.setScene(value);
           // rootLayout.setCenter(signUpUI);
            
            
            //give the controller access to the main app
            
           
            //LoginUIController controller = loader.getController();
            
           // controller.initConnectioToServer(host,port);
            

            //loader.setController(controller);
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
