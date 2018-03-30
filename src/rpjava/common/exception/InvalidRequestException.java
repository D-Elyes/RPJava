/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.common.exception;

/**
 *
 * @author Florent BERLAND
 */


// Thrown when a request has invalid data or verb
public class InvalidRequestException extends Exception {
    
    public InvalidRequestException(String msg){
        super(msg);
    }
    
}
