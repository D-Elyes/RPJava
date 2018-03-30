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
 *
 * @author Florent BERLAND
 */
public class ClientConsole implements UIIF {

    RPJClient client;
    
    public ClientConsole(String ip, int port){
        client = new RPJClient(ip, port, this);
        try {
            client.openConnection();
        } catch (IOException ex) {
            this.connectionException(ex);
        }
        this.login();
    }
    
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
    
    public void receiveUserData(User u) {
        System.out.println("Succesfully connected to server.\nNickname : " + u.getNickName());
    }

    public void invalidLogin(InvalidAccountException e) {
        System.out.println("Invalid login or password. Please try again");
        login();
    }

    public void connectionException(Exception e) {
        System.out.println("An error occured whilst trying to connect to server");
        try {
            System.in.read();
        } catch (IOException ex) {
            Logger.getLogger(ClientConsole.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(1);
    }
    
    public static void main(String[] args) throws IOException{
        ClientConsole cc = new ClientConsole("localhost", 12345);
    }

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
