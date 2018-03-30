/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.client.UI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import rpjava.client.RPJClient;

/**
 * FXML Controller class
 *
 * @author doude
 */
public class MainMenuUIController implements Initializable {

    private RPJClient client;
    private RPJavaMainApp mainApp;
    
    
    public MainMenuUIController(RPJClient client)
    {
        this.client = client;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
    
     public void setRPJavaMainApp(RPJavaMainApp mainApp)
    {
        this.mainApp = mainApp;
        
    }
     
     public void logOffButton()
     {
         mainApp.setUser(null);
         mainApp.showLoginUI();
     }
     
     public void npcButton()
     {
         mainApp.showNpcManageUI();
     
     }
}
