/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.server;

import DerbyJavaDb.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lib.ocsf.server.*;
import rpjava.common.*;
import rpjava.common.exception.*;

/**
 *
 * @author Florent BERLAND
 */
public class RPJServer extends AbstractServer {

    AccountDAO accountDAO;
    
    public RPJServer(int port, AccountDAO accountDAO) {
        super(port);
        this.accountDAO = accountDAO;
    }

    @Override
    protected void handleMessageFromClient(Object msg, ConnectionToClient client) {
        if(msg instanceof Account){
            User userConnected = accountDAO.signIn((Account)msg);
            try{
                if (userConnected != null){
                    client.sendToClient(userConnected);
                } else {
                    client.sendToClient(new InvalidAccountException());
                }
            } catch (IOException e){
                
            }
        }
    }
    
     public static void main(String[] args){
        RPJServer server = new RPJServer(12345, null);
        try {
            server.listen();
            System.out.println("Server listening on port " + server.getPort());
        } catch (IOException ex) {
            Logger.getLogger(RPJServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
