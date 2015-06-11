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


    public List<Tag> getTagList() {
        return this.tagList;
    }

    public void addTag(Tag tag){
        this.tagList.add(tag);
    }

    public Tag getTagByTitle(String tagTitle) {
        for(Tag iTag: tagList){
            if(iTag.getTitle().equals(tagTitle)){
                return iTag;
            }
        }
        return null;
    }
}
