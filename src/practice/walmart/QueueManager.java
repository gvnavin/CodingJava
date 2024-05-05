package practice.walmart;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class QueueManager<T> {

    static class Holder {
        static QueueManager<T> instance = new QueueManager<>();
    }

    public static QueueManager<T> getInstance() {
        return Holder.instance;
    }

    HashMap<String,  Queue<T>> subscriptionKeyToQueueHashMap = new HashMap<>();
    private final Queue<T> q = new ArrayDeque<>();

    private QueueManager() {
    }

    public Queue<T> getQ() {
        return q;
    }

    public void createQueue(String subscriptionKey) {
        if(subscriptionKeyToQueueHashMap.containsKey(subscriptionKey)) {

        } else {

        }
    }
}
