package ejb;

import entities.NewsItem;
import entities.Topic;
import manager.TopicManager;
import broker.Broker;
import broker.IBroker;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Gergely on 25.05.2015.
 */

@Stateless
public class TopicEJB {
    private TopicManager topicManager = TopicManager.getInstance();

    @Inject
    IBroker newsBroker;

    public TopicEJB(){
        this.newsBroker = Broker.getInstance();
    }

    public Topic addTopic(String s) {
        Topic newTopic = new Topic();
        newTopic.setTitle(s);
        topicManager.addTopic(newTopic);
        newsBroker.channelAddedEvent(newTopic);
        return newTopic;
    }

    public Topic addNewsToTopic(String topicTitle, NewsItem n){
        Topic iTopic = topicManager.getTopicByTitle(topicTitle);
        //iTopic.getNewsItemSet().add(n);
        n.getTopicSet().add(iTopic);
        newsBroker.publishEvent(iTopic, n);
        return iTopic;
    }


    public Topic getTopicByTitle(String topicTitle) {
       return topicManager.getTopicByTitle(topicTitle);
    }

    public List<Topic> getTopicList() {
        return topicManager.getTopicList();
    }
}
