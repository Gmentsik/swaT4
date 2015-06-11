package controller;

import ejb.TopicEJB;
import entities.Topic;
import session.UserSession;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Gergely on 25.05.2015.
 */

@ManagedBean(name="topicController")
@RequestScoped
public class TopicController {
    @Inject
    private UserSession userSession;

    @EJB
    private TopicEJB topicEJB;

    private List<Topic> topicList;
    private String topicTitle;

    @PostConstruct
    public void refreshNewsList(){
        this.topicList = topicEJB.getTopicList();
    }

    public void addTopic(){
        String result;

        if(!topicList.contains(topicEJB.getTopicByTitle(topicTitle))){
            topicEJB.addTopic(topicTitle);
            topicList = topicEJB.getTopicList();
            result = "Topic added!";
        }else{
            result = "Topic already exitsts!";
        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, result,  null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }
}
