/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpjava.common;

import java.util.*;

/**
 *
 * @author Elwès
 */
public class User {
    
    private String nickName;
    private int age;
    private Collection<User> friends;
    private Account account;

    public User(String nickName, int age, Account account) {
        this.nickName = nickName;
        this.age = age;
        friends = new LinkedList<>();
        this.account = account;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Collection<User> getFriends() {
        return friends;
    }

    public Account getAccount() {
        return account;
    }
    
}
