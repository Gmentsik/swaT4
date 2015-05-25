package entities;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Gergely on 25.05.2015.
 */
public class NewsReader extends User {
    private int maxItems;
    private Set<Topic> subscribedTopics = new HashSet<>();

    public NewsReader(){}

    public NewsReader(String username, String password) {
        super(username,password);
        this.maxItems = 10;
    }

    public int getMaxItems() {
        return maxItems;
    }

    public void setMaxItems(int maxItems) {
        this.maxItems = maxItems;
    }

    public Set<Topic> getSubscribedTopics() {
        return subscribedTopics;
    }

    public void setSubscribedTopics(Set<Topic> subscribedTopics) {
        this.subscribedTopics = subscribedTopics;
    }
}
