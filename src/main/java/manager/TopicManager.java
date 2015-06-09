package manager;

import entities.Topic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gergely on 02.06.2015.
 */
public class TopicManager {
    private static TopicManager ourInstance = new TopicManager();

    public static TopicManager getInstance() {
        return ourInstance;
    }

    private List<Topic> topicList = new ArrayList<>();

    private TopicManager() {}

    public void addTopic(Topic t) {
        topicList.add(t);
    }

    public Topic getTopic(Topic t) {
        for(Topic iTopic: topicList){
            if(iTopic == t){
                return iTopic;
            }
        }
        return null;
    }

    public Topic getTopicByTitle(String topicTitle) {
        for(Topic iTopic: topicList){
            if(iTopic.getTitle().equals(topicTitle)){
                return iTopic;
            }
        }
        return null;
    }
}
