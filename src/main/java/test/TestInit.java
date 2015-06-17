package test;

import ejb.NewsItemEJB;
import ejb.TagEJB;
import ejb.TopicEJB;
import ejb.UserEJB;
import entities.NewsItem;
import entities.NewsReader;
import entities.NewsWriter;
import entities.Topic;
import broker.Broker;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.Serializable;

/**
 * Created by Gergely on 25.05.2015.
 */
@ManagedBean(name = "testInit")
@Stateless
public class TestInit implements Serializable {

    @EJB
    UserEJB userEJB;

    @EJB
    NewsItemEJB newsItemEJB;

    @EJB
    TagEJB tagEJB;

    @EJB
    TopicEJB topicEJB;


    public void doInit() {
        String initText = "testreader // A1test <br> testwriter // A1test <br> and test news initialized!";
        if(userEJB.getNewsReaderByName("testreader") == null) {
            Broker broker = Broker.getInstance();

            NewsReader testreader = userEJB.addNewsReader("testreader", "A1test");
            NewsWriter testwriter = userEJB.addNewsWriter("testwriter", "A1test");

            NewsItem n1 = newsItemEJB.addNewsItem("First News Item", "This is some <b>bold content</b>" , testwriter);
            NewsItem n2 = newsItemEJB.addNewsItem("Second News Item", "This is some <b>bold content</b>", testwriter);
            NewsItem n3 = newsItemEJB.addNewsItem("Third News Item", "This is some <b>bold content</b>" , testwriter);
            NewsItem n4 = newsItemEJB.addNewsItem("Fourth News Item", "This is some <b>bold content</b>", testwriter);
            NewsItem n5 = newsItemEJB.addNewsItem("Fifth News Item", "This is some <b>bold content</b>" , testwriter);

            Topic t1 = topicEJB.addTopic("Topic 1");
            Topic t2 = topicEJB.addTopic("Topic 2");
            Topic t3 = topicEJB.addTopic("Topic 3");
            Topic t4 = topicEJB.addTopic("Topic 4");
            Topic t5 = topicEJB.addTopic("Topic 5");



            userEJB.subscribeToTopic(testreader,t1);
            userEJB.subscribeToTopic(testreader,t2);
            userEJB.subscribeToTopic(testreader,t3);

            topicEJB.addNewsToTopic("Topic 1", n1);
            topicEJB.addNewsToTopic("Topic 1", n2);
            topicEJB.addNewsToTopic("Topic 1", n3);
            topicEJB.addNewsToTopic("Topic 2", n4);
            topicEJB.addNewsToTopic("Topic 3", n5);
            topicEJB.addNewsToTopic("Topic 5", n3);
            topicEJB.addNewsToTopic("Topic 4", n4);

            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, initText,  null);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

}
