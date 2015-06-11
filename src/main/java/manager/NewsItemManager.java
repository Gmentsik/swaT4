package manager;

import entities.NewsItem;
import entities.NewsWriter;

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

    public NewsItem addNewsItem(String newsItemTitle, String newsItemContent, NewsWriter author) {
        NewsItem newsItem = new NewsItem(this.newsItemList.size(),newsItemTitle,newsItemContent);
        newsItem.setAuthor(author);
        System.out.println("Add NewsItem: " + newsItem.toString());
        newsItemList.add(newsItem);
        return newsItem;
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
