/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.client;

import DerbyJavaDb.AccountDaoDerby;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import rpjava.common.Account;
import rpjava.common.User;

/**
 *
 * @author doude
 */
public class RPJava extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root,1000,680);
        
        
        
        primaryStage.setTitle("RPJava");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
      /* AccountDaoDerby test = new AccountDaoDerby();
       Account a = new Account("rien", "je sais pas");
       
       try
       {
            User u = test.signIn(a);
            if(u != null)
            {
                System.out.println("Je suis connecté !!!!!!!!!!");
            }
            else
            {
                System.out.println("NOOOOOOOOOOOOOOOOOOOO");
            }
       }
       catch(Exception e)
       {
           System.out.println(e.getMessage());
       }*/
      
       
       
        
    }
    
}
