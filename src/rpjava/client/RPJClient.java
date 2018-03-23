/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.client;

import rpjava.common.exception.*;
import lib.ocsf.client.AbstractClient;
import rpjava.common.*;

/**
 *
 * @author Florent BERLAND
 */
public class RPJClient extends AbstractClient {

   // private static RPJClient client;
    /*public static RPJClient getClient(String host, int port, LoginIF clientUI){
        if (client == null){
            client = new RPJClient(host, port, clientUI);
        }
        return client;
    }*/
    
    private UIIF ui;
    
    public RPJClient(String host, int port, UIIF ui) {
        super(host, port);
        this.ui = ui;
    }
    
    public RPJClient(String host, int port) {
        super(host, port);
    }
    
    public void setUI(UIIF ui){
        this.ui = ui;
    }
    
    @Override
    protected void handleMessageFromServer(Object msg) {
        if(ui != null){
            ui.handleMessage(msg);
        } else {
            System.err.println("Error : this instance of RPJClient does not have a ui");
        }  
    }
    
    @Override
    protected void connectionException(Exception e) {
        if(ui != null){
            ui.handleMessage(e);
        } else {
            System.err.println("Error : this instance of RPJClient does not have a ui");
        }
    }
}
