/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.client;

/**
 *
 * @author Elwès
 */
public interface LoginIF {
    
    public void receiveUserData(Object o);
    public void InvalidLogin();
    public void connectionException(Exception e);
}
