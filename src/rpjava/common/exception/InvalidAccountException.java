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
public class InvalidAccountException extends Exception {
    
    public InvalidAccountException(String message){
        super(message);
    }
}
