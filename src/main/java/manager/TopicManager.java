package manager;

/**
 * Created by Gergely on 02.06.2015.
 */
public class TopicManager {
    private static TopicManager ourInstance = new TopicManager();

    public static TopicManager getInstance() {
        return ourInstance;
    }

    private TopicManager() {
    }
}
