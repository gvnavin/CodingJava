package coupang;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SlidingWindowRateLimiter_V0 implements RateLimiter {

    private final Config config;

    //in real world, it can be some db redis
    private final Map<String, PriorityQueue<Long>> clientIdToTimestampMap = new HashMap<>();

    public SlidingWindowRateLimiter_V0(Config config) {
        this.config = config;
    }

    /**
     * Create a map of client id to requests time stamp
     *
     * @param clientId
     * @return
     */
    @Override
    public boolean isAllowed(String clientId) {

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
        while(!pq.isEmpty() && pq.peek() < currentTimeMillis - 1000) {
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
