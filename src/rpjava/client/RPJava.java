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
      
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //launch(args);
        AccountDaoDerby test = new AccountDaoDerby();
        
        Account acc = new Account("test", "123456");
        
        try
        {
            User user = test.signIn(acc);
            if(user != null)
            {
                System.out.println(user.getNickName()+"\n"+user.getAge()+"\n");
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}
