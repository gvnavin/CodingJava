package ratelimitmuthu;

import java.util.HashMap;
import java.util.Map;

public class FixedWindowRateLimiterImpl {
//        implements IRateLimiter {

    static class Window {
        long startTime;
        int counter;
        int availableCredits;

        public Window(long startTime, int counter, int availableCredits) {
            this.startTime = startTime;
            this.counter = counter;
            this.availableCredits = availableCredits;
        }

        public long getStartTime() {
            return startTime;
        }

        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }

        public int getCounter() {
            return counter;
        }

        public void setCounter(int counter) {
            this.counter = counter;
        }

        public int getAvailableCredits() {
            return availableCredits;
        }

        public void setAvailableCredits(int availableCredits) {
            this.availableCredits = availableCredits;
        }
    }

    private final int timeWindowInSeconds;
    private final int requestsAllowed;
    private final Map<Integer, Window> customerToRequestCountMap;
    private final int maxCredits;


    public FixedWindowRateLimiterImpl(int timeWindowInSeconds, int requestsAllowed, int maxCredits) {
        this.timeWindowInSeconds = timeWindowInSeconds;
        this.requestsAllowed = requestsAllowed;
        this.customerToRequestCountMap = new HashMap<>();
        this.maxCredits = maxCredits;
    }

//    @Override
    public boolean ratelimit(int customerId) {
        final long currentTimeInSeconds = System.currentTimeMillis() / 1000;
        final long currentWindowStartTimeInSeconds = currentTimeInSeconds -  (System.currentTimeMillis() / 1000) / timeWindowInSeconds;
        if(!customerToRequestCountMap.containsKey(customerId)) {
            Window window = new Window(currentWindowStartTimeInSeconds, 1, 0);
            customerToRequestCountMap.put(customerId, window);
            return true;
        }

        Window window = customerToRequestCountMap.get(customerId);
        if(window.getStartTime() == currentWindowStartTimeInSeconds) {
            if(requestsAllowed > window.getCounter()) {
                window.setCounter(window.getCounter() + 1);
                return true;
            } else if(window.getAvailableCredits() > 0){
                window.setAvailableCredits(window.getAvailableCredits() - 1);
                return true;
            }
            return false;
        }

        int credits = calculateCreditsForCustomer(customerId, currentWindowStartTimeInSeconds, window);

        Window newWindow = new Window(currentWindowStartTimeInSeconds, 1, credits);
        customerToRequestCountMap.put(customerId, newWindow);
        return true;
    }

    private int calculateCreditsForCustomer(int customerId, long currentWindowStartTime, Window window) {
        long lastUsedWindowStartTime = window.getStartTime();
        int unusedCountsInLastWindow = requestsAllowed - window.getCounter();

        int numberOfUnusedWindows =  (int) (((currentWindowStartTime - lastUsedWindowStartTime)) / timeWindowInSeconds) - 1;
        int creditsFromUnusedWindows = (numberOfUnusedWindows * requestsAllowed) + unusedCountsInLastWindow;
        return Math.min(maxCredits, creditsFromUnusedWindows);
    }
}


