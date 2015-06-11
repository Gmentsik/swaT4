package ejb;

import entities.NewsItem;
import entities.NewsWriter;
import manager.NewsItemManager;

import javax.ejb.Stateless;


/**
 * Created by Gergely on 25.05.2015.
 */

@Stateless
public class NewsItemEJB {
    NewsItemManager newsItemManager = NewsItemManager.getInstance();

    public NewsItem addNewsItem(String newsItemTitle, String newsItemContent, NewsWriter author) {
        return newsItemManager.addNewsItem(newsItemTitle, newsItemContent, author);
    }


    public NewsItem getNewsItemById(int newsItemID) {
        return newsItemManager.findNewsItemByID(newsItemID);
    }


}
