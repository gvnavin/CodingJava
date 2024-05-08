package companies.twilio;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Implement a queueing system that meets the following requirement:
 * <p>
 * func enqueue(userid, data) - Adds the data which belongs to the specified user to the queue
 * func dequeueItems(numOfItems) - returns the specified number of items from the beginning of the queue making sure that each user has a fair chance of getting their items dequeued.
 * <p>
 * Assume that we have an unknown number of unique users
 */

public class Main {

    static enum Status {
        SUCCESS,
        FAILED
    }

    public static class CustomQueue {

        //multi thread env, to handle synchronization
        ConcurrentHashMap<String, Queue<String>> userIdToQueueMap;

        public CustomQueue() {
            userIdToQueueMap = new ConcurrentHashMap<>();

        }

        public Status enqueue(String userId, String payload) {
            try {
                Queue<String> queue = userIdToQueueMap.getOrDefault(userId, new ConcurrentLinkedQueue<>());
                queue.add(payload);
                userIdToQueueMap.put(userId, queue);
                return Status.SUCCESS;
            } catch (Exception e) {
                return Status.FAILED;
            }
        }

        public synchronized List<String> deQueue(int noOfItems) {
            Set<Map.Entry<String, Queue<String>>> entries = userIdToQueueMap.entrySet();
            ArrayList<Map.Entry<String, Queue<String>>> entriesArray = new ArrayList<>(entries);

            List<String> itemsToReturn = new ArrayList<>();

            int itemsAdded = 0;
            for (int i = 0; itemsAdded < noOfItems; i = (i + 1) % entriesArray.size()) {

                if (userIdToQueueMap.isEmpty()) {
                    break;
                }

                Map.Entry<String, Queue<String>> userIdtoDequeEntry = entriesArray.get(i);
                Queue<String> queue = userIdtoDequeEntry.getValue();
                String userId = userIdtoDequeEntry.getKey();
                if (queue.isEmpty()) {
                    userIdToQueueMap.remove(userId);
                } else {
                    String pop = queue.poll();
                    itemsToReturn.add(pop);
                    itemsAdded ++;
                    if (queue.isEmpty()) {
                        userIdToQueueMap.remove(userId);
                    } else {
                        userIdToQueueMap.put(userId, queue);
                    }
                }
            }
            return itemsToReturn;
        }

        @Override
        public String toString() {
            return "CustomQueue{" +
                    "userIdToQueueMap=" + userIdToQueueMap +
                    '}';
        }
    }

    public static void main(String[] args) {

        CustomQueue customQueue = new CustomQueue();
        customQueue.enqueue("user_1", "u1p1");
        System.out.println("customQueue = " + customQueue);

        customQueue.enqueue("user_1", "u1p2");
        System.out.println("customQueue = " + customQueue);

        customQueue.enqueue("user_2", "u2p1");
        System.out.println("customQueue = " + customQueue);

        customQueue.enqueue("user_3", "u3p1");
        System.out.println("customQueue = " + customQueue);

        customQueue.enqueue("user_3", "u3p2");
        System.out.println("customQueue = " + customQueue);

        List<String> strings;

        strings = customQueue.deQueue(2);
        System.out.println("customQueue = " + customQueue);
        System.out.println("strings = " + strings);

        strings = customQueue.deQueue(1);
        System.out.println("customQueue = " + customQueue);
        System.out.println("strings = " + strings);

//        strings = customQueue.deQueue(3);
//        System.out.println("customQueue = " + customQueue);
//        System.out.println("strings = " + strings);


    }
}
