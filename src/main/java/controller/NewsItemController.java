package controller;

import ejb.NewsItemEJB;
import entities.NewsItem;
import session.UserSession;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gergely on 25.05.2015.
 */

//@ManagedBean(name="newsItemController")
@RequestScoped
@Named
public class NewsItemController {

    @Inject
    private UserSession userSession;


    @EJB
    private NewsItemEJB newsItemEJB;

    private NewsItem newsItem = new NewsItem();
    private List<NewsItem> newsItemList = new ArrayList<>();
    private List<NewsItem> filteredNewsItemList = new ArrayList<>();
    private String newsTitle;
    private String newsContent;




    private String getNewsFeed;

    public String addNewsItem(){
        if(newsItem != null){
            System.out.println("Added: " + newsItemEJB.addNewsItem(newsTitle, newsContent).getTitle());
            return "/index.xhtml";
        }
        return null;
    }

    public List<NewsItem> getNewsFeed(){

        if(userSession.isLoggedIn()) {
            System.out.println("GetNewsFeed1: " + userSession.getUserName());
            if(userSession.isReader()) {
                System.out.println("GetNewsFeed2: " + userSession.getUserName());
                if(userSession.getCurrentUser() != null){
                    System.out.println("GetNewsFeed3: " + userSession.getUserName());
                    newsItemList = newsItemEJB.generateNewsFeed();
                    return newsItemList;
                }
            }
        }

        return null;
    }

    public NewsItem getNewsItemById(int newsItemID){
        return newsItemEJB.getNewsItemById(newsItemID);
    }

    public NewsItemEJB getNewsItemEJB() {
        return newsItemEJB;
    }

    public void setNewsItemEJB(NewsItemEJB newsItemEJB) {
        this.newsItemEJB = newsItemEJB;
    }

    public NewsItem getNewsItem() {
        return newsItem;
    }

    public void setNewsItem(NewsItem newsItem) {
        this.newsItem = newsItem;
    }

    public List<NewsItem> getNewsItemList() {
        return newsItemList;
    }

    public void setNewsItemList(List<NewsItem> newsItemList) {
        this.newsItemList = newsItemList;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public UserSession getUserSession() {
        return userSession;
    }

    public void setUserSession(UserSession userSession) {
        this.userSession = userSession;
    }

    public List<NewsItem> getFilteredNewsItemList() {
        return filteredNewsItemList;
    }

    public void setFilteredNewsItemList(List<NewsItem> filteredNewsItemList) {
        this.filteredNewsItemList = filteredNewsItemList;
    }

}
