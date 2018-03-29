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
import rpjava.client.UIIF;

/**
 * FXML Controller class
 *
 * @author doude
 */
public class RecoveryPasswordUIController implements Initializable, UIIF {

    
    private RPJClient client;
    //Reference to the main app
    private RPJavaMainApp mainApp;
    
    public RecoveryPasswordUIController(RPJClient client)
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

    public void setRPJavaMainApp(RPJavaMainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    
    

    @Override
    public void handleMessage(Object msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
