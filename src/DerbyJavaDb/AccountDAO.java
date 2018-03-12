/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DerbyJavaDb;

import rpjava.common.Account;

/**
 *
 * @author doude
 */
public abstract class AccountDAO {
    
    public abstract Account signIn(String login, String password);
    public abstract Boolean signUp(String login, String password);
    public abstract Boolean updateAccount(String login, String password);
    public abstract Boolean deleteAccout(String login, String password);
    
    
}
