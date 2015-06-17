package entities;

import broker.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gergely on 25.05.2015.
 */
public class NewsItem extends Message{
    private int id;
    private String title;
    private String content;
    private List<Topic> topicSet = new ArrayList<>();
    private List<Tag> tagSet = new ArrayList<>();
    private Boolean read = false;
    private NewsWriter author;
    private String topicString;
    private String tagString;

    public NewsItem(){}

    public NewsItem(int newsItemID){
        this.id = newsItemID;
    }

    public NewsItem(int newsItemID, String title, String content){
        this.id = newsItemID;
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "NewsItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", tagSet=" + tagSet +
                '}';
    }

    public String getTopicString() {
        topicString = "";
        for(Topic topic : topicSet){
            topicString = topicString + topic.getTitle() + " ";
        }
        return topicString;
    }

    public void setTopicString(String topicString) {
        this.topicString = topicString;
    }

    public String getTagString() {
        tagString = "";
        for(Tag tag : tagSet){
            tagString = tagString + tag.getTitle() + " ";
        }
        return tagString;
    }

    public void setTagString(String tagString) {
        this.tagString = tagString;
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

    public List<Topic> getTopicSet() {
        return topicSet;
    }

    public void setTopicSet(List<Topic> topicSet) {
        this.topicSet = topicSet;
    }

    public List<Tag> getTagSet() {
        return tagSet;
    }

    public void setTagSet(List<Tag> tagSet) {
        this.tagSet = tagSet;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }



    public NewsWriter getAuthor() {
        return author;
    }

    public void setAuthor(NewsWriter author) {
        this.author = author;
    }
}
