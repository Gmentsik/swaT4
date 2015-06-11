package entities;

import util.Message;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Gergely on 25.05.2015.
 */
public class NewsItem extends Message{
    private int id;
    private String title;
    private String content;
    private Set<Topic> topicSet = new HashSet<>();
    private Set<Tag> tagSet = new HashSet<>();
    private Boolean read = false;
    private NewsWriter author;

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

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    public Set<Tag> getTagSet() {
        return tagSet;
    }

    public void setTagSet(Set<Tag> tagSet) {
        this.tagSet = tagSet;
    }

    public NewsWriter getAuthor() {
        return author;
    }

    public void setAuthor(NewsWriter author) {
        this.author = author;
    }
}
