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

// This class will be used to send to server some data requests from a specific user
public class UserRequest {
    
    private int userID;
    private UserRequestOn dataType;
    private UserRequestAction action;
    private Object data; // Additional data to send to the server, for example a friend to add

    public UserRequest(int userID, UserRequestOn dataType, UserRequestAction action, Object data) {
        this.userID = userID;
        this.dataType = dataType;
        this.action = action;
        this.data = data;
    }

    public int getUserID() {
        return userID;
    }

    public UserRequestOn getDataType() {
        return dataType;
    }

    public UserRequestAction getAction() {
        return action;
    }

    public Object getData() {
        return data;
    }
    
    
    // The type of data which will be involved
    public enum UserRequestOn {
        FRIENDS,
        NPCS,
        MAPS
    }
    
    // Type of action to the server
    public enum UserRequestAction {
        GET,
        SAVE,
        UPDATE,
        DELETE
    }
}


