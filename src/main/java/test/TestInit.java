package test;

import ejb.NewsItemEJB;
import ejb.TagEJB;
import ejb.TopicEJB;
import ejb.UserEJB;
import entities.NewsItem;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 * Created by Gergely on 25.05.2015.
 */
@Named(value = "testInit")
@RequestScoped
public class TestInit {
    @EJB
    UserEJB userEJB;

    @EJB
    NewsItemEJB newsItemEJB;

    @EJB
    TagEJB tagEJB;

    @EJB
    TopicEJB topicEJB;

    @PostConstruct
    public void init(){
        NewsItem n1 = newsItemEJB.addNewsItem("First News Item", "This is some <b>bold content</b>");
        NewsItem n2 = newsItemEJB.addNewsItem("Second News Item","This is some <b>bold content</b>");
        NewsItem n3 = newsItemEJB.addNewsItem("Third News Item","This is some <b>bold content</b>");
        NewsItem n4 = newsItemEJB.addNewsItem("Fourth News Item","This is some <b>bold content</b>");
        NewsItem n5 = newsItemEJB.addNewsItem("Fifth News Item","This is some <b>bold content</b>");

        userEJB.addNewsReader("testreader","A1test");
        userEJB.addNewsWriter("testwriter","A1test");

        topicEJB.addTopic("Topic 1");
        topicEJB.addTopic("Topic 2");
        topicEJB.addTopic("Topic 3");
        topicEJB.addTopic("Topic 4");
        topicEJB.addTopic("Topic 5");

        topicEJB.addNewsToTopic("Topic 1", n1);
        topicEJB.addNewsToTopic("Topic 1", n2);
        topicEJB.addNewsToTopic("Topic 1", n3);
        topicEJB.addNewsToTopic("Topic 2", n2);
        topicEJB.addNewsToTopic("Topic 3", n5);
        topicEJB.addNewsToTopic("Topic 5", n3);
        topicEJB.addNewsToTopic("Topic 4", n4);

    }
}
