package ejb;

import entities.NewsReader;
import entities.NewsWriter;
import manager.UserManager;

import javax.ejb.Stateless;

/**
 * Created by Gergely on 25.05.2015.
 */

@Stateless
public class UserEJB {
    UserManager userManager = UserManager.getInstance();

    public NewsWriter addNewsWriter(String username, String password) {
        return userManager.addNewsWriter(username, password);
    }

    public NewsReader addNewsReader(String username, String password) {
        return userManager.addNewsReader(username, password);
    }
}
