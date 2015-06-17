package entities;

import broker.ISubscriber;
import broker.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gergely on 25.05.2015.
 */
public class NewsReader extends User implements ISubscriber {
    private int maxItems;
   // private Set<Topic> subscribedTopics = new HashSet<>();
    private List<NewsItem> newsFeed = new ArrayList<>();


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

    public List<NewsItem> getNewsFeed() {
        return newsFeed;
    }

    public void setNewsFeed(List<NewsItem> newsFeed) {
        this.newsFeed = newsFeed;
    }


    @Override
    public void pushMessage(Message message) {
        NewsItem newsItem = (NewsItem) message;
        System.out.println("["+this.getUsername()+"] pushMessageRecieve(" + newsItem.toString() + ");");
        for(NewsItem newsItem1 : newsFeed){
            if(newsItem1.getId() == newsItem.getId()){
                System.out.println("[NReader] Updated!");
                int index = newsFeed.indexOf(newsItem1);
                newsFeed.set(index, newsItem);
                return;
            }
        }
        System.out.println("["+this.getUsername()+"] Added!");
        newsFeed.add(newsItem);
    }
}
