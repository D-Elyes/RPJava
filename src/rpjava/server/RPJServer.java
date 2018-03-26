/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.server;

import rpjava.server.dao.*;
import DerbyJavaDb.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lib.ocsf.server.*;
import rpjava.common.*;
import rpjava.common.exception.*;
import rpjava.common.wrappers.*;

/**
 *
 * @author Florent BERLAND
 */
public class RPJServer extends AbstractServer {

    AccountDAO accountDAO;
    NpcDAO npcDAO;
    
    public RPJServer(int port, AbstractFactoryDao daoGenerator) {
        super(port);
        this.accountDAO = daoGenerator.createAccountDao();
        this.npcDAO = daoGenerator.createNpcDao();
    }

    @Override
    protected void handleMessageFromClient(Object msg, ConnectionToClient client) {
        if(msg instanceof AccountQuery){
            handleAccountQuery((AccountQuery)msg, client);
        } else if(msg instanceof UserRequest){
            UserRequest request = (UserRequest)msg;
            switch(request.getDataType()){
                case FRIENDS:{
                    break;
                }
                case MAPS:{
                    break;
                }
                case NPCS:{
                    handleNpcQuery(request.getUserID(), request.getAction(), request.getData(), client);
                    break;
                }
                default:{
                    try {
                        client.sendToClient(new InvalidRequestException("Data type not known"));
                    } catch (IOException ex) {
                        Logger.getLogger(RPJServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
    
    protected void handleAccountQuery(AccountQuery query, ConnectionToClient client)
    {
        switch(query.getType()){
            case SIGNIN: {                   
                try{
                    User userConnected = accountDAO.signIn(query.getAccount());
                    if (userConnected != null){
                        client.sendToClient(userConnected);
                    } else {
                        client.sendToClient(new InvalidAccountException("Unknown identifier or password"));
                    }
                } catch (Exception e){}
                break;
            }
            case SIGNUP: {
                try{
                    if (accountDAO.signUp(query.getAccount())){
                        client.sendToClient(query.getAccount());
                    } else {
                        client.sendToClient(new InvalidAccountException("Cannot create an account with this name"));
                    }
                } catch (Exception e){}
                break;
            }
            case UPDATE: {
                break;
            }
            case DELETE: {
                try{
                    if(accountDAO.deleteAccout(query.getAccount())){                      
                    } else {
                        client.sendToClient(new InvalidAccountException("Cannot delete this account"));
                    }
                } catch (Exception e){}
                break;
            }
            default : break;
        }
    }
    
    protected void handleNpcQuery(int userID, UserRequest.UserRequestAction action, Object data, ConnectionToClient client){
        
    }
    
     public static void main(String[] args){
         
        RPJServer server = new RPJServer(12345, new FactoryDaoDerby());
        try {
            server.listen();
            System.out.println("Server listening on port " + server.getPort());
        } catch (IOException ex) {
            Logger.getLogger(RPJServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
