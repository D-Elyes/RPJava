/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.common.wrappers;

/**
 *
 * @author Florent BERLAND
 */
public class UserResult {
    
    private Object data;
    private UserRequest.UserRequestOn type;

    public UserResult(Object data, UserRequest.UserRequestOn type) {
        this.data = data;
        this.type = type;
    }

    public Object getData() {
        return data;
    }

    public UserRequest.UserRequestOn getType() {
        return type;
    }
}
