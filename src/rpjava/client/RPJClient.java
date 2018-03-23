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
    
    LoginIF loginUI;
    
    public RPJClient(String host, int port, LoginIF loginUI) {
        super(host, port);
        this.loginUI = loginUI;
    }
    
    @Override
    protected void handleMessageFromServer(Object msg) {
        if(msg instanceof User){
            loginUI.receiveUserData((User)msg);
        } else if (msg instanceof InvalidAccountException){
            loginUI.InvalidLogin((InvalidAccountException)msg);
        }
    }
    
    @Override
    protected void connectionException(Exception e) {
        loginUI.connectionException(e);
    }
}
