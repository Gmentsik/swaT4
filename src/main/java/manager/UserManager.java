package manager;

import entities.NewsReader;
import entities.NewsWriter;
import entities.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gergely on 25.05.2015.
 */
public class UserManager {

    private List<User> userList = new ArrayList<>();
    private List<NewsReader> newsReaderList = new ArrayList<>();
    private List<NewsWriter> newsWriterList = new ArrayList<>();

    private static UserManager ourInstance = new UserManager();

    public static UserManager getInstance() {
        return ourInstance;
    }

    private UserManager() {

    }

    public User findUser(String username, String password){
        System.out.println("[UserManager.findUser("+ username + ", " + password + "):]");
        System.out.println(userList.toString());
        return userList.get(userList.indexOf(new User(username,password)));
    }

    public NewsReader addNewsReader(String username, String password){
        System.out.println("[UserManager.addNewsReader("+ username + ", " + password + "):]");
        NewsReader newsReader = new NewsReader(username, password);
        newsReaderList.add(newsReader);
        userList.add(newsReader);
        System.out.println(userList.toString());
        return newsReader;
    }

    public NewsWriter addNewsWriter(String username, String password){
        System.out.println("[UserManager.addNewsWriter("+ username + ", " + password + "):]");
        NewsWriter newsWriter = new NewsWriter(username,password);
        newsWriterList.add(newsWriter);
        userList.add(newsWriter);
        System.out.println(userList.toString());
        return newsWriter;
    }
}
