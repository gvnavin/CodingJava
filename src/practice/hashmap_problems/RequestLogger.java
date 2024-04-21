package practice.hashmap_problems;

import java.util.HashMap;

public class RequestLogger {

    private final int timeLimit;
    HashMap<String, Integer> messageToTimestampMap = new HashMap<>();

    public RequestLogger(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public boolean messageRequestDecision(int timestamp, String request) {
        System.out.println("timestamp = " + timestamp + ", request = " + request);
        System.out.println("messageToTimestampMap = " + messageToTimestampMap);
        if (!messageToTimestampMap.containsKey(request)) {
            System.out.println("if (!messageToTimestampMap.containsKey(request)) {");
            messageToTimestampMap.put(request, timestamp);
            return true;
        }

        Integer oldTimestamp = messageToTimestampMap.get(request);
        System.out.println("oldTimestamp = " + oldTimestamp);
        if (timestamp > oldTimestamp + timeLimit) {
            messageToTimestampMap.put(request, timestamp);
            return true;
        }

        return false;
    }

}
