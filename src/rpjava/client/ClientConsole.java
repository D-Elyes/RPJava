/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.client;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import rpjava.common.*;
import rpjava.common.exception.InvalidAccountException;
import rpjava.common.wrappers.*;

/**
 * This class allows the client to ask for commands in the console.
 * @author RPJavaTeam
 */
public class ClientConsole implements UIIF {

// INSTANCE VARIABLES ***********************************************
     
    /**
      * Creation of the connection to Client. Can't be changed.
     */ 
    RPJClient client;
    
// CONSTRUCTOR ***********************************************
     
    /**
      * Creation of a ClientConsole.
      * @param ip The ip of the client
      * @param port The port used by the client
     */ 
    public ClientConsole(String ip, int port){
        client = new RPJClient(ip, port, this);
        try {
            client.openConnection();
        } catch (IOException ex) {
            this.connectionException(ex);
        }
        this.login();
    }
    
    
// INSTANCE METHODS ***********************************************
     
    /**
      * This method is called when the user wants to log in.
     */ 
    public void login(){
        try {
            System.out.print("Username : ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String username = br.readLine();
            System.out.print("Password : ");
            String password = br.readLine();
            client.sendToServer(new AccountQuery(new Account(username, password), AccountQuery.QueryType.SIGNIN));
        } catch (IOException ex) {
            this.connectionException(ex);
        }
    }
    
     /**
      * This method just confirms the User is connected.
      * @param u The User who wants to connect
     */ 
    public void receiveUserData(User u) {
        System.out.println("Succesfully connected to server.\nNickname : " + u.getNickName());
    }

    
     /**
      * This method is called the identifiers do not correspond. It calls login once again just after.
      * @param e The happening exception
     */ 
    public void invalidLogin(InvalidAccountException e) {
        System.out.println("Invalid login or password. Please try again");
        login();
    }

    
     /**
      * This method is called when a problem with the login occurs.
      * @param e The happening exception
     */ 
    public void connectionException(Exception e) {
        System.out.println("An error occured whilst trying to connect to server");
        try {
            System.in.read();
        } catch (IOException ex) {
            Logger.getLogger(ClientConsole.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(1);
    }
    
     /**
      * Main method
      * @param args The usual arguments called with the method
      * @throws IOException The exception which could occur when starting the application
     */ 
    public static void main(String[] args) throws IOException{
        ClientConsole cc = new ClientConsole("localhost", 12345);
    }

      /**
      * This method shows th the current ClientConsole how to treat a receiving message
      * @param msg The message received by the ClientConsole
     */ 
    @Override
    public void handleMessage(Object msg) {
        if(msg instanceof InvalidAccountException){
            invalidLogin((InvalidAccountException)msg);
        } else if(msg instanceof Exception){
            connectionException((Exception)msg);
        } else if(msg instanceof User){
            receiveUserData((User)msg);
        } else {
            System.out.println("Error : object " + msg.getClass().getName() + " not valid for the login");
        }
    }
    
}
