package coupang;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

public class SlidingWindowRateLimiter_V3 implements RateLimiter {

    private final Config config;

    //in real world, it can be some db redis
    private final Map<String, PriorityQueue<Long>> clientIdToTimestampMap = new ConcurrentHashMap<String, PriorityQueue<Long>>();

    public SlidingWindowRateLimiter_V3(Config config) {
        this.config = config;
    }

    /**
     * If 2 threads with different client id - ConcurrentHashMap will handle
     *
     */
    /**
     * Create a map of client id to requests time stamp
     *
     * @param clientId
     * @return
     */
    @Override
    //simple way to handle
//    public synchronized boolean isAllowed(String clientId) {
    public boolean isAllowed(String clientId) {

        synchronized (clientId) {

            //new client
            if (!clientIdToTimestampMap.containsKey(clientId)) {
                PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.naturalOrder());
                pq.add(System.currentTimeMillis());
                clientIdToTimestampMap.put(clientId, pq);
                return true;
            }

            PriorityQueue<Long> pq = clientIdToTimestampMap.get(clientId);

//        System.out.println("pq = " + pq);

            long currentTimeMillis = System.currentTimeMillis();
            //removing old entries
            while (!pq.isEmpty() && pq.peek() < currentTimeMillis - (config.getNumberOfSeconds() * 1000)) {
                pq.poll();
            }

            if (pq.size() < config.getNumberOfRequestsAllowed()) {
                pq.add(System.currentTimeMillis());
                clientIdToTimestampMap.put(clientId, pq);
                return true;
            } else {
                return false;
            }

        }
    }
}
