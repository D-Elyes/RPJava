/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.client;
import ocsf.client.AbstractClient;
/**
 *
 * @author Florent BERLAND
 */
public class RPJClient extends AbstractClient {

    private static RPJClient client;
    public static RPJClient getClient(String host, int port, LoginIF clientUI){
        if (client == null){
            client = new RPJClient(host, port, clientUI);
        }
        return client;
    }
    
    LoginIF clientUI;
    
    private RPJClient(String host, int port, LoginIF clientUI) {
        super(host, port);
        this.clientUI = clientUI;
    }
    
    @Override
    protected void handleMessageFromServer(Object msg) {
        
    }
    
    @Override
    protected void connectionException(Exception e) {
        clientUI.connectionException(e);
    }
}
