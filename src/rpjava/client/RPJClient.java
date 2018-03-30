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
 * This class is one of the two main classes to use. It allows the user to create a client connected to the server.
 * @author RPJavaTeam
 * @version 1.0 
 */ 

public class RPJClient extends AbstractClient {

   // private static RPJClient client;
    /*public static RPJClient getClient(String host, int port, LoginIF clientUI){
        if (client == null){
            client = new RPJClient(host, port, clientUI);
        }
        return client;
    }*/

// INTANCES PROPERTIES ---------------------------------------------------------

    /**
     * Property that will contain tne user interface. 
     */     
    private UIIF ui;

// CONSTRUCTOR ---------------------------------------------------------
    
    /**
     * This method create an instance of RPJClient.
     * @param host The adress of the host 
     * @param port The port which is used by the client
     * @param ui The user interface that will be displayed
     */     
    public RPJClient(String host, int port, UIIF ui) {
        super(host, port);
        this.ui = ui;
    }
    
    /**
     * This method create an instance of RPJClient.
     * @param host The adress of the host 
     * @param port The port which is used by the client
     */
    public RPJClient(String host, int port) {
        super(host, port);
    }


// INSTANCE METHODS ---------------------------------------------------------    
    
    /**
     * This method allows you to change the user interface.
     * @param ui The new user interface 
     *  
     */
    public void setUI(UIIF ui){
        this.ui = ui;
    }
    
    /**
    * This method shows to the current RPJClient how to treat a receiving message.
    * @param msg The message received by the RPJClient
       */ 
    @Override
    protected void handleMessageFromServer(Object msg) {
        if(ui != null){
            ui.handleMessage(msg);
        } else {
            System.err.println("Error : this instance of RPJClient does not have a ui");
        }  
    }

    /**
    * This method shows to the current RPJClient how to treat a receiving exception.
    * @param e The exception received by the RPJClient
       */ 

    @Override
    protected void connectionException(Exception e) {
        if(ui != null){
            ui.handleMessage(e);
        } else {
            System.err.println("Error : this instance of RPJClient does not have a ui");
        }
    }
}
