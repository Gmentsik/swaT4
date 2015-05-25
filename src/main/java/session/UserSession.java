package session;

import entities.NewsReader;
import entities.NewsWriter;
import entities.User;
import manager.UserManager;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Gergely on 25.05.2015.
 */

@Named
@SessionScoped
public class UserSession implements Serializable{
    private User    currentUser     = null;
    private String  userPassword    = null;
    private String  userName        = null;

    UserManager userManager = UserManager.getInstance();


    public String login(){
        currentUser = userManager.findUser(userName,userPassword);
        return "/index.xhtml";
    }

    public boolean isLoggedIn(){
       return currentUser != null;
    }

    public boolean isReader(){
        return currentUser instanceof NewsReader;
    }

    public boolean isWriter(){
        return currentUser instanceof NewsWriter;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
