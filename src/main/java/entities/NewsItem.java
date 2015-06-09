package entities;

import java.util.Set;

/**
 * Created by Gergely on 25.05.2015.
 */
public class NewsItem {
    private int id;
    private String title;
    private String content;
    private Set<Topic> topicSet;
    private Set<Tag> tagSet;

    public NewsItem(){}

    public NewsItem(int newsItemID){
        this.id = newsItemID;
    }

    public NewsItem(int newsItemID, String title, String content){
        this.id = newsItemID;
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<Topic> getTopicSet() {
        return topicSet;
    }

    public void setTopicSet(Set<Topic> topicSet) {
        this.topicSet = topicSet;
    }

    public Set<Tag> getTagSet() {
        return tagSet;
    }

    public void setTagSet(Set<Tag> tagSet) {
        this.tagSet = tagSet;
    }
}
