/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.client;

/**
 *  This class os the super class of user interface.
 * @author RPJavaTeam
 * @version 1.0
 */
public interface UIIF {
    
    /**
    * This method shows to the current UIIF how to treat a receiving message. Right now, because UIIF is an interf  ce, this method is empty.
    * @param msg The message received by the UIIF
    */ 

    public void handleMessage(Object msg);
    
}
