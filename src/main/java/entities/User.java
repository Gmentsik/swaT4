package entities;

import javax.validation.constraints.Pattern;

/**
 * Created by Gergely on 25.05.2015.
 */
public class User{
    private String username;

    @Pattern(regexp = "((?=.*\\d)(?=.*[A-Z]).{6,})", message = "{invalid.password}")
    private String password;

    public User(){}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User){
            if(this.getUsername().equals(((User)obj).getUsername())){
                if(this.getPassword().equals(((User)obj).getPassword())){
                    return true;
                }
            }
        }
        return false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
