package ejb;

import entities.NewsItem;
import entities.NewsReader;
import entities.NewsWriter;
import entities.Topic;
import manager.UserManager;
import session.UserSession;
import broker.Broker;
import broker.IBroker;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Gergely on 25.05.2015.
 */

@Stateless
public class UserEJB{
    private UserManager userManager = UserManager.getInstance();

    @Inject
    UserSession userSession;

    @Inject
    IBroker newsBroker;

    public UserEJB(){
        this.newsBroker = Broker.getInstance();
   }

    public NewsWriter addNewsWriter(String username, String password) {
        return userManager.addNewsWriter(username, password);
    }

    public NewsReader addNewsReader(String username, String password) {
        return userManager.addNewsReader(username, password);
    }

    public NewsReader getNewsReaderByName(String username) {
        return userManager.getNewsReader(username);
    }

    public void subscribeToTopic(NewsReader newsReader, Topic t) {
       // userManager.getNewsReader(newsReader.getUsername()).getSubscribedTopics().add(t));
        newsBroker.subscribeEvent(t,newsReader);
    }

    public List<NewsItem> getNewsFeed() {
        NewsReader newsReader = userManager.getNewsReader(userSession.getUserName());
        return newsReader.getNewsFeed();
    }
}
