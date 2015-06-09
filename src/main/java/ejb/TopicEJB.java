package ejb;

import entities.NewsItem;
import entities.Topic;
import manager.TopicManager;

import javax.ejb.Stateless;

/**
 * Created by Gergely on 25.05.2015.
 */

@Stateless
public class TopicEJB {
    private TopicManager topicManager = TopicManager.getInstance();

    public Topic addTopic(String s) {
        Topic newTopic = new Topic();
        Topic.setTitle(s);
        topicManager.addTopic(newTopic);
        return newTopic;
    }

    public Topic addNewsToTopic(String topicTitle, NewsItem n){
        Topic iTopic = topicManager.getTopicByTitle(topicTitle);
        iTopic.getNewsItemSet().add(n);
        return iTopic;
    }
}
