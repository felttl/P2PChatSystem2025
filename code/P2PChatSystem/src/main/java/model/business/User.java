package model.business;

import model.Network;
import model.Network;

public class User {


    private String userId;
    private String name;

    public User(String name) {
        this.userId = Network.getMacAddress();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getUserId() {
        return userId;
    }
    
    
}