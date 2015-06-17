package controller;

import ejb.NewsItemEJB;
import ejb.TagEJB;
import entities.NewsItem;
import entities.Tag;
import session.UserSession;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gergely on 25.05.2015.
 */

@ManagedBean(name="tagController")
@RequestScoped
public class TagController {
    @Inject
    UserSession userSession;

    @EJB
    TagEJB tagEJB;

    @EJB
    NewsItemEJB newsItemEJB;


    private List<Tag> tagList = new ArrayList<>();
    private List<String> tagListString = new ArrayList<>();

    @PostConstruct
    public void init(){
        tagList = tagEJB.getTagList();
            }

    public String assignTag(String tagTitle, String newsID){
        Tag iTag = tagEJB.getTagByTitle(tagTitle);
        System.out.println("[TagController] assignTag("+tagTitle+", "+newsID+")");
        if(!tagList.contains(iTag)){
            tagList.add(iTag);
        }
        NewsItem newsItem = newsItemEJB.getNewsItemById(Integer.parseInt(newsID));
        newsItem.getTagSet().add(iTag);
        //iTag.getNewsItemSet().add(newsItem);
        tagEJB.updateTags(newsItem);
        return "/index.xhtml";
    }
}
