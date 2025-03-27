package p2pchatsystem.main.model.business;

public class User {
    private String userIp;
    private String name;

    public User(String name, String address) {
        this.userIp = address;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }
}