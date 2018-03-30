
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.client.UI;

import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import rpjava.client.RPJClient;
import rpjava.common.NPC;
import rpjava.common.Race;
import rpjava.common.User;

/**
 *
 * @author doude
 */
public class RPJavaMainApp extends Application {
    
    final private  String host = "localhost";
    final private int port = 12345;
    private RPJClient client;
    private User user;
    
    
    private Stage primaryStage;
    
    private ObservableList<Race> raceData = FXCollections.observableArrayList();
    private ObservableList<NPC> npcData = FXCollections.observableArrayList();
    
    @Override
    public void start(Stage primaryStage)  {
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
      
       // initRootLayout();
        
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    
}
