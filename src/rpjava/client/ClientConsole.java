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
public class ClientConsole implements LoginIF {

    RPJClient client;
    
    public ClientConsole(String ip, int port){
        client = RPJClient.getClient(ip, port, this);
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
    
    @Override
    public void receiveUserData(User u) {
        System.out.println("Succesfully connected to server.\nNickname : " + u.getNickName());
    }

    @Override
    public void InvalidLogin(InvalidAccountException e) {
        System.out.println("Invalid login or password. Please try again");
        login();
    }

    @Override
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
    
}
