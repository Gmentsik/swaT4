package broker;

/**
 * Created by Gergely on 10.06.2015.
 */

public interface IBroker {
    void publishEvent(Channel channel, Message message);
    void updateEvent(Channel channel, Message message);
    void subscribeEvent(Channel channel, ISubscriber subscriber);
    void unsubscribeEvent(Channel channel, ISubscriber subscriber);
    void channelAddedEvent(Channel channel);
}
