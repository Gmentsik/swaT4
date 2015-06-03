package manager;

/**
 * Created by Gergely on 02.06.2015.
 */
public class TagManager {
    private static TagManager ourInstance = new TagManager();

    public static TagManager getInstance() {
        return ourInstance;
    }

    private TagManager() {
    }
}
