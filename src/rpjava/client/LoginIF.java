/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.client;

import rpjava.common.exception.InvalidAccountException;
import rpjava.common.User;

/**
 *
 * @author Elwès
 */
public interface LoginIF {
    
    public void receiveUserData(User u);
    public void InvalidLogin(InvalidAccountException e);
    public void connectionException(Exception e);
}
