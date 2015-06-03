package ejb;

import entities.NewsItem;
import entities.NewsReader;
import manager.NewsItemManager;
import manager.UserManager;
import session.UserSession;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Gergely on 25.05.2015.
 */

@Stateless
public class NewsItemEJB {
    NewsItemManager newsItemManager = NewsItemManager.getInstance();
    UserManager userManager = UserManager.getInstance();

    @Inject
    UserSession userSession;


    public NewsItem addNewsItem(String newsItemTitle, String newsItemContent) {
        return newsItemManager.addNewsItem(newsItemTitle, newsItemContent);
    }

    public NewsItem getNewsItemById(int newsItemID) {
        return newsItemManager.findNewsItemByID(newsItemID);
    }

    public List<NewsItem> generateNewsFeed() {
        NewsReader newsReader = userManager.getNewsReader(userSession.getUserName());
        List<NewsItem> newsItemList = newsItemManager.getNewsItemList();
        List<NewsItem> newsFeed = new ArrayList<>();

        
        for(NewsItem newsItem: newsItemList){
            newsFeed.add(newsItem);
            System.out.println(newsItem.getTitle());
        }

        return newsFeed;
    }
}
