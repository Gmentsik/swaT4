package controller;

import ejb.UserEJB;
import entities.NewsReader;
import entities.NewsWriter;
import entities.User;
import session.UserSession;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gergely on 25.05.2015.
 */

@ManagedBean(name="userController")
@RequestScoped
public class UserController {

    @EJB
    private UserEJB userEJB;

    private User user = new User();
    private NewsReader newsReader = new NewsReader();
    private NewsWriter newsWriter = new NewsWriter();
    private List<User> userList = new ArrayList<>();

    @ManagedProperty(value = "#{userSession}")
    private UserSession userSession;

    public String addNewsWriter(){
        if(user != null){
            userEJB.addNewsWriter(user.getUsername(),user.getPassword());
            return "/index.xhtml";
        }
        return null;
    }

    public String addNewsReader(){
        if(user != null){
            userEJB.addNewsReader(user.getUsername(),user.getPassword());
            return "/index.xhtml";
        }
        return null;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public NewsReader getNewsReader() {
        return newsReader;
    }

    public void setNewsReader(NewsReader newsReader) {
        this.newsReader = newsReader;
    }

    public NewsWriter getNewsWriter() {
        return newsWriter;
    }

    public void setNewsWriter(NewsWriter newsWriter) {
        this.newsWriter = newsWriter;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
