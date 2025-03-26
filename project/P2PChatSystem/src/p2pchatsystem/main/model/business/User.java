package p2pchatsystem.main.model.business;

import p2pchatsystem.main.model.Network;

public class User {

    private String userId;
    private String address;
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

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Builder design pattern

    public User builder(){
        return this;
    }
    public User addAddress(String addr){
        this.address = addr;
        return this;
    }
    public User addName(String name) {
        this.name = name;
        return this;
    }
    
    
}