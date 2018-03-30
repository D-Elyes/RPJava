/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.server;

import DerbyJavaDb.FactoryDaoDerby;
import rpjava.server.dao.*;
import java.io.IOException;
import java.sql.SQLException;
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
    MapDAO mapDAO;
    CharacterDAO characterDAO;
    
    public RPJServer(int port, AbstractFactoryDao daoGenerator) {
        super(port);
        this.accountDAO = daoGenerator.createAccountDao();
        this.npcDAO = daoGenerator.createNpcDao();
        this.mapDAO = daoGenerator.createMapDao();
        this.characterDAO = daoGenerator.createCharacterDAO();
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
                case CHARSET:{
                    handleCharSetQuery(request.getUserID(), request.getAction(), request.getData(), client);
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
    
    protected void handleCharSetQuery(int userID, UserRequest.UserRequestAction action, Object data, ConnectionToClient client){
        switch(action){
            case GET:{
                try {
                    Player[] players = characterDAO.getCharacters(userID);
                    client.sendToClient(new UserResult(players, UserRequest.UserRequestOn.CHARSET));
                } catch (SQLException ex) {
                    Logger.getLogger(RPJServer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException e){}
                break;
            }
            case SAVE:{
                try {
                    characterDAO.addCharacter(userID, (Player)data);
                } catch (SQLException ex) {
                    Logger.getLogger(RPJServer.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case UPDATE:{
                try {
                    this.characterDAO.updateCharacter(userID, ((Player[])data)[0], ((Player[])data)[1]);
                } catch (SQLException ex) {
                    Logger.getLogger(RPJServer.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case DELETE:{
                try {
                    this.characterDAO.deleteCharacter(userID, (Player)data);
                } catch (SQLException ex) {
                    Logger.getLogger(RPJServer.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            default:{
                try {
                    client.sendToClient(new InvalidRequestException("Verb " + action.toString() + " does not exist"));
                } catch (IOException ex) {
                    Logger.getLogger(RPJServer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    protected void handleAccountQuery(AccountQuery query, ConnectionToClient client)
    {
        switch(query.getType()){
            case SIGNIN: {                   
                try{
                    User userConnected = accountDAO.signIn((Account)query.getData());
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
                    Object[] data = (Object[])query.getData();
                    if (accountDAO.signUp((Account)data[0], (User)data[1])){
                        client.sendToClient(accountDAO.signIn((Account)data[0]));
                    } else {
                        client.sendToClient(new InvalidAccountException("Cannot create an account with this name"));
                    }
                } catch (Exception e){}
                break;
            }
            case UPDATE: {
                Account[] data = (Account[])query.getData();
                try {
                    accountDAO.updateAccount(data[0], data[1]);
                } catch (SQLException ex) {
                    Logger.getLogger(RPJServer.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case DELETE: {
                try{
                    if(accountDAO.deleteAccout((Account)query.getData())){                      
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
        switch(action) {
            case GET:{
                try {
                    NPC[] result = this.npcDAO.getNpcs(userID);
                    client.sendToClient(new UserResult(result, UserRequest.UserRequestOn.NPCS));
                } catch (SQLException ex) {
                    Logger.getLogger(RPJServer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException e) {}
                break;
            }
            case SAVE:{
                try {
                    this.npcDAO.addNpc(userID, (NPC)data);
                } catch (SQLException ex) {
                    Logger.getLogger(RPJServer.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case UPDATE:{
                try {
                    this.npcDAO.updateNpc(userID, ((NPC[])data)[0], ((NPC[])data)[1]);
                } catch (SQLException ex) {
                    Logger.getLogger(RPJServer.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case DELETE:{
                try {
                    this.npcDAO.deleteNpc(userID, (NPC)data);
                } catch (SQLException ex) {
                    Logger.getLogger(RPJServer.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            default:{
                try {
                    client.sendToClient(new InvalidRequestException("Verb " + action.toString() + " does not exist"));
                } catch (IOException ex) {
                    Logger.getLogger(RPJServer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
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
