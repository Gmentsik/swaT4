package entities;

import util.Channel;

/**
 * Created by Gergely on 25.05.2015.
 */

public class Topic extends Channel{

    private String title;
   // private Set<NewsItem> newsItemSet = new HashSet<>();

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }


}
