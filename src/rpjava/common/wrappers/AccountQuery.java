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
    
    private Account account;
    private QueryType type;
    
    public AccountQuery(Account account, QueryType type){
        this.account = account;
        this.type = type;
    }

    public Account getAccount() {
        return account;
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
