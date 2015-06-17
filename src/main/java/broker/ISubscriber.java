package broker;

/**
 * Created by Gergely on 10.06.2015.
 */
public interface ISubscriber {
    void pushMessage(Message message);
}
