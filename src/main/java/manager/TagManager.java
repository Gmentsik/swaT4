package manager;

import entities.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gergely on 02.06.2015.
 */
public class TagManager {
    private static TagManager ourInstance = new TagManager();

    public static TagManager getInstance() {
        return ourInstance;
    }

    private List<Tag> tagList = new ArrayList<>();

    private TagManager() {}


}
