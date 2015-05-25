package entities;

import javax.validation.constraints.Pattern;

/**
 * Created by Gergely on 25.05.2015.
 */
public class User {
    private String username;

    @Pattern(regexp = "((?=.*\\d)(?=.*[A-Z]).{6,})", message = "{invalid.password}")
    private String password;

    public User(){}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
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
