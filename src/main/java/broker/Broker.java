package broker;

import javax.ejb.Singleton;
import java.util.*;

/**
 * Created by Gergely on 10.06.2015.
 */
@Singleton(name = "newsBroker")
public class Broker implements IBroker{


    private Map<Channel, List<ISubscriber>> channelSubscriptions = new HashMap<>();
    private Map<Channel, List<Message>> messageQue = new HashMap<>();

    private static Broker ourInstance = new Broker();


    public static Broker getInstance() {
        return ourInstance;
    }

    public Broker() {}

    @Override
    public void publishEvent(Channel channel, Message message) {
        System.out.println("[Broker] publishEvent(" + channel.toString() + ", " + message.toString() + ");");
        if(messageQue.containsKey(channel)){
            messageQue.get(channel).add(message);
            notifySubscribers(channel, message);
        }
    }

    @Override
    public void updateEvent(Channel channel, Message message) {

            notifySubscribers(channel, message);
    }

    @Override
    public void subscribeEvent(Channel channel, ISubscriber subscriber) {
        if(channelSubscriptions.containsKey(channel)){
            //List<ISubscriber> subscriberList = channelSubscriptions.get(channel);
            channelSubscriptions.get(channel).add(subscriber);
        }
    }

    @Override
    public void unsubscribeEvent(Channel channel, ISubscriber subscriber) {

    }

    @Override
    public void channelAddedEvent(Channel channel) {
        channelSubscriptions.put(channel, new ArrayList<>());
        messageQue.put(channel,new ArrayList<>());
    }

    public void notifySubscribers(Channel channel, Message message){
       if(channelSubscriptions.containsKey(channel)){
           for(ISubscriber subscriber : channelSubscriptions.get(channel)){
               subscriber.pushMessage(message);
           }
       }
    }

}
