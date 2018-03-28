/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.common.wrappers;

import java.io.Serializable;
import rpjava.common.*;

/**
 *
 * @author Florent BERLAND
 */
public class AccountQuery implements Serializable {
    
    private Object data;
    private QueryType type;

    public AccountQuery(Object data, QueryType type) {
        this.data = data;
        this.type = type;
    }

    public Object getData() {
        return data;
    }

    public QueryType getType() {
        return type;
    }
    
    public enum QueryType implements Serializable {
        SIGNIN,
        SIGNUP,
        UPDATE,
        DELETE
    }
}
