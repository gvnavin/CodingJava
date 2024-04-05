package atlassian.algo;

import atlassian.Config;
import atlassian.RequestStatus;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SlidingWindowAlgo implements RateLimitAlgo {

    private Config config;

    public SlidingWindowAlgo(Config config) {
        this.config = config;
    }

    //    HashMap<String, List<Long>> idToRequestTimestampLogMap = new HashMap<>();

    //can use priority queue as well
    ConcurrentHashMap<String, PriorityQueue<Long>> idToRequestTimestampLogMap = new ConcurrentHashMap<String, PriorityQueue<Long>>();

    @Override
    public RequestStatus isAllowed(String id) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!idToRequestTimestampLogMap.containsKey(id)) {
            PriorityQueue<Long> timestampLogs = new PriorityQueue<>(Comparator.naturalOrder());
            timestampLogs.add(currentTimeMillis);
            idToRequestTimestampLogMap.put(id, timestampLogs);
        }

        PriorityQueue<Long> timestampLogs = idToRequestTimestampLogMap.get(id);

        //if priority queue is not thread safe.
        synchronized (timestampLogs) {
            long currentWindowStartingTimeStamp = currentTimeMillis - config.getDuration();
            while (!timestampLogs.isEmpty()) {
                Long peek = timestampLogs.peek();

                if (peek < currentWindowStartingTimeStamp) {
                    timestampLogs.poll();
                } else {
                    break;
                }
            }
        }

        if (timestampLogs.size() >= config.getNoOfRequests()) {
            return RequestStatus.DENY;
        }

        timestampLogs.add(currentTimeMillis);
        idToRequestTimestampLogMap.put(id, timestampLogs);

        return RequestStatus.ALLOW;
    }
}
