package controller;

import ejb.NewsItemEJB;
import ejb.TopicEJB;
import ejb.UserEJB;
import entities.NewsItem;
import entities.NewsWriter;
import session.UserSession;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gergely on 25.05.2015.
 */

@ManagedBean(name="newsItemController")
@ViewScoped
public class NewsItemController {

    @Inject
    private UserSession userSession;

    @EJB
    private NewsItemEJB newsItemEJB;

    @EJB
    private TopicEJB topicEJB;

    @EJB
    private UserEJB userEJB;

    private NewsItem newsItem = new NewsItem();
    private List<NewsItem> newsItemList = new ArrayList<>();
    private List<NewsItem> filteredNewsItemList = new ArrayList<>();
    private String newsTitle;
    private String newsContent;
    private List<String> assignedTopics;



    public String addNewsItem(){
        if(newsItem != null && userSession.getCurrentUser() instanceof NewsWriter){
            NewsItem newsItem = newsItemEJB.addNewsItem(newsTitle, newsContent, (NewsWriter) userSession.getCurrentUser());
            for(String iTopic: assignedTopics){

                topicEJB.addNewsToTopic(iTopic,newsItem);
            }
            return "/index.xhtml";
        }
        return null;
    }
    public List<NewsItem> getNewsFeed(){
        if(userSession.isLoggedIn()) {
            if(userSession.isReader()) {
                if(userSession.getCurrentUser() != null){
                    return filteredNewsItemList = userEJB.getNewsFeed();
                }
            }
        }
        return null;
    }

    public void markRead(String newsID){
                int nID = Integer.parseInt(newsID);
        System.out.println("NewsItemController.markRead("+newsID+");");
        for(NewsItem newsItem: userEJB.getNewsFeed()){
            if(newsItem.getId() == nID) {
                if (newsItem.getRead()) {
                    newsItem.setRead(false);
                } else {
                    newsItem.setRead(true);
                }
            }
        }

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

    public List<String> getAssignedTopics() {
        return assignedTopics;
    }

    public void setAssignedTopics(List<String> assignedTopics) {
        this.assignedTopics = assignedTopics;
    }
}
