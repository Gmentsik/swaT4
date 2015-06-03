package manager;

import entities.NewsReader;
import entities.NewsWriter;
import entities.User;

import java.util.ArrayList;
import java.util.Iterator;
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
        System.out.print("[UserManager.findUser(" + username + ", " + password + "):");

        Iterator userIterator = userList.iterator();
        User findUser = new User(username,password);

        while(userIterator.hasNext()){
            User user = (User) userIterator.next();
            if(user.equals(findUser)){
                System.out.print("User(" + user.getUsername() + ", " + user.getPassword() + ");\n");
                return user;
            }
        }
        System.out.print(" null \n");
        return null;
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

    public NewsReader getNewsReader(String userName) {
        Iterator userIterator = userList.iterator();

        while(userIterator.hasNext()){
            NewsReader newsReader = (NewsReader) userIterator.next();
            if(newsReader.getUsername().equals(userName)){
                return newsReader;
            }
        }
        return null;
    }

    public NewsWriter getNewsWriter(String userName){
        Iterator userIterator = userList.iterator();

        while(userIterator.hasNext()){
            NewsWriter newsWriter = (NewsWriter) userIterator.next();
            if(newsWriter.getUsername().equals(userName)){
                return newsWriter;
            }
        }
        return null;
    }
}
