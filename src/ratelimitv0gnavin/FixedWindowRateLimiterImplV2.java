package ratelimitv0gnavin;

import java.util.HashMap;

public class FixedWindowRateLimiterImplV2 implements IRateLimiter {

    private int windowDurationInSeconds;
    private int noOfRequestsPerWindow;
    private int maxCreditsPerWindow;

    private HashMap<Integer, Window> customerIdToWindowMap = new HashMap<>();

    public FixedWindowRateLimiterImplV2(int windowDurationInSeconds, int noOfRequestsPerWindow, int maxCreditsPerWindow) {
        this.windowDurationInSeconds = windowDurationInSeconds;
        this.noOfRequestsPerWindow = noOfRequestsPerWindow;
        this.maxCreditsPerWindow = maxCreditsPerWindow;
    }

    public long getCurrentTimeStampInSeconds() {
        return System.currentTimeMillis() / 1000;
    }

    @Override
    public boolean ratelimit(int customerId) {
        System.out.println("customerId = " + customerId);
        long currentTimeStampInSeconds = getCurrentTimeStampInSeconds();
        System.out.println("currentTimeStampInSeconds = " + currentTimeStampInSeconds);
        System.out.println("customerIdToWindowMap = " + customerIdToWindowMap);
        if (!customerIdToWindowMap.containsKey(customerId)) {
            System.out.println("if (!customerIdToWindowMap.containsKey(customerId)) {");
            Window window = new Window(currentTimeStampInSeconds, 1, maxCreditsPerWindow);
            customerIdToWindowMap.put(customerId, window);
            return true;
        }

        Window existingWindow = customerIdToWindowMap.get(customerId);
        if (isNewWindow(existingWindow, currentTimeStampInSeconds)) {
            System.out.println("if (isNewWindow(existingWindow, currentTimeStampInSeconds)) {");
            long availableCredits = calculateAvailableCredits(existingWindow, currentTimeStampInSeconds);
            Window newWindow = new Window(currentTimeStampInSeconds, 1, availableCredits);
            customerIdToWindowMap.put(customerId, newWindow);
            return true;
        }

        //current window
        if (existingWindow.getNoOfRequestsServed() < noOfRequestsPerWindow) {
            System.out.println("if (existingWindow.getNoOfRequestsServed() < noOfRequestsPerWindow) {");
            existingWindow.setNoOfRequestsServed(existingWindow.getNoOfRequestsServed() + 1);
            customerIdToWindowMap.put(customerId, existingWindow);
            return true;
        }

        //current window used limit and credits are available
        if (existingWindow.getAvailableCredits() > 0) {
            System.out.println("if (existingWindow.getAvailableCredits() > 0) {");
            existingWindow.setAvailableCredits((int) (existingWindow.getAvailableCredits() - 1));
            customerIdToWindowMap.put(customerId, existingWindow);
            return true;
        }

        if (existingWindow.getAvailableCredits() <= 0) {
            System.out.println("if (existingWindow.getAvailableCredits() <= 0) {");
            return false;
        }

        return false;
    }

    private long calculateAvailableCredits(Window window, long currentTimeStampInSeconds) {
        long diffOfCurrentTimestampAndLastWindowStartTimestamp = currentTimeStampInSeconds - window.getStartTimestamp();
        long noOfWindow = diffOfCurrentTimestampAndLastWindowStartTimestamp/windowDurationInSeconds;

        return noOfWindow * maxCreditsPerWindow;
    }

    private boolean isNewWindow(Window window, long currentTimeStampInSeconds) {
        return currentTimeStampInSeconds > window.getStartTimestamp() + windowDurationInSeconds;
    }
}


