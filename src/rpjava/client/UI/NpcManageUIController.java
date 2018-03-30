/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.client.UI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import rpjava.client.RPJClient;
import rpjava.common.NPC;
import rpjava.common.Race;

/**
 * FXML Controller class
 *
 * @author doude
 */
public class NpcManageUIController implements Initializable {

   @FXML
   private TableView<Race> raceListTableView;
   
   @FXML
   private TableView<NPC> npcListTableView;
    
   @FXML
   private TextField levelTF;
   
   @FXML
   private CheckBox aggressiveCB;
   
   @FXML
   private CheckBox bossCB;
   
   @FXML
   private TextField nameTF;
   
   @FXML
   private ImageView image;
   
   private RPJavaMainApp mainApp;
   private RPJClient client;
    
    
    public NpcManageUIController(RPJClient client)
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
    
}
