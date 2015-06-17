package entities;

import java.util.List;

/**
 * Created by Gergely on 25.05.2015.
 */
public class Tag {
    private String title;
    private List<NewsItem> newsItemSet;

    public Tag() {
    }

    public Tag(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<NewsItem> getNewsItemSet() {
        return newsItemSet;
    }

    public void setNewsItemSet(List<NewsItem> newsItemSet) {
        this.newsItemSet = newsItemSet;
    }
}
