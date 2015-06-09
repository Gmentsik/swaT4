package entities;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Gergely on 25.05.2015.
 */
public class Topic {
    private static String title;
    private Set<NewsItem> newsItemSet = new HashSet<>();

    public static void setTitle(String title) {
        Topic.title = title;
    }

    public static String getTitle() {
        return title;
    }

    public Set<NewsItem> getNewsItemSet() {
        return newsItemSet;
    }

    public void setNewsItemSet(Set<NewsItem> newsItemSet) {
        this.newsItemSet = newsItemSet;
    }
}
