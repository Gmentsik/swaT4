package ejb;

import entities.NewsItem;
import entities.Tag;
import entities.Topic;
import manager.TagManager;
import util.Broker;
import util.IBroker;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Gergely on 25.05.2015.
 */

@Stateless
public class TagEJB {

    TagManager tagManager = TagManager.getInstance();

    @Inject
    IBroker newsBroker;

    public TagEJB(){
        this.newsBroker = Broker.getInstance();
    }

    public List<Tag> getTagList() {
        return tagManager.getTagList();
    }

    public void updateTags(NewsItem newsItem){
        for(Topic topic : newsItem.getTopicSet()){
            newsBroker.updateEvent(topic, newsItem);
        }
    }

    public Tag getTagByTitle(String tagTitle) {
        return tagManager.getTagByTitle(tagTitle);
    }
}
