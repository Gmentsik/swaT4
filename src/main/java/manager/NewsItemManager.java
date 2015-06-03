package manager;

import entities.NewsItem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Gergely on 02.06.2015.
 */
public class NewsItemManager {

    private List<NewsItem> newsItemList = new ArrayList<>();

    private static NewsItemManager ourInstance = new NewsItemManager();

    public static NewsItemManager getInstance() {
        return ourInstance;
    }

    private NewsItemManager() {}

    public NewsItem addNewsItem(String newsItemTitle, String newsItemContent) {
        NewsItem newsItem = new NewsItem(this.newsItemList.size(),newsItemTitle,newsItemContent);
        newsItemList.add(newsItem);
        return newsItemList.get(this.newsItemList.size()-1);
    }

    public NewsItem findNewsItem(NewsItem newsItem){
        Iterator newsIterator = newsItemList.iterator();
        while(newsIterator.hasNext()){
            NewsItem currentNewsItem = (NewsItem) newsIterator.next();
            if(currentNewsItem.equals(newsItem)){
                return currentNewsItem;
            }
        }
        return null;
    }

    public NewsItem findNewsItemByID(int newsItemID){
        Iterator newsIterator = newsItemList.iterator();
        while(newsIterator.hasNext()){
            NewsItem currentNewsItem = (NewsItem) newsIterator.next();
            if(currentNewsItem.getId() == newsItemID){
                return currentNewsItem;
            }
        }
        return null;
    }

    public void removeNewsItem(NewsItem newsItem){
        if(this.findNewsItem(newsItem) != null){
            this.newsItemList.remove(newsItem);
        }
    }

    public List<NewsItem> getNewsItemList() {
        return newsItemList;
    }

    public void setNewsItemList(List<NewsItem> newsItemList) {
        this.newsItemList = newsItemList;
    }
}
