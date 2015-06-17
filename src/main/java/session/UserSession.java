package session;

import entities.NewsReader;
import entities.NewsWriter;
import entities.User;
import manager.UserManager;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Gergely on 25.05.2015.
 */

@SessionScoped
@Named(value="userSession")
public class UserSession implements Serializable{
    private User    currentUser     = null;
    private String  userPassword    = null;
    private String  userName        = null;

    UserManager userManager = UserManager.getInstance();

    public String login(){
        currentUser = userManager.findUser(userName,userPassword);
        return "/index.xhtml";
    }


    public String logout(){
        if(currentUser != null){
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            currentUser = null;
        }
        return "index.xhtml";
    }

    @Produces
    @Named("currentUser")
    @LoggedIn
    public User getCurrentUser(){
        if(currentUser != null){
            currentUser = userManager.findUser(currentUser.getUsername(),currentUser.getPassword());
        }
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
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
