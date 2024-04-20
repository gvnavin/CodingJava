package practice.slidingwindow_fixed.core;

import java.util.HashMap;

public class FixedSlidingStringWindow {

    int windowBeg = 0;
    int windowEnd = 0;
    int windowSize = 0;
    private final String inp;

    HashMap<WindowTrackingKey, WindowTrackingValue<String>> windowTracker = new HashMap<>();
    HashMap<String, Integer> windowValueCountTracker = new HashMap<>();

    public FixedSlidingStringWindow(String inp, int windowSize) {
        this.windowSize = windowSize;
        this.inp = inp;
        windowBeg = 0;
        windowEnd = windowSize - 1;
    }

    public void init() {
        trackWindow();
    }

    private void trackWindow() {
        String subStr = "";
        if (windowEnd + 1 < inp.length()) {
            subStr = inp.substring(windowBeg, windowEnd + 1);
        } else {
            subStr = inp.substring(windowBeg);
        }
        WindowTrackingKey key = getCurrentWindowKey();
        WindowTrackingValue<String> val = new WindowTrackingValue<String>(subStr, windowBeg, windowEnd);
        windowTracker.put(key, val);
        windowValueCountTracker.merge(val.value, 1, (val1, val2) -> val1 + 1);
    }

    public void move() {
        windowBeg++;
        windowEnd = Math.min(windowEnd + 1, inp.length() - 1);
        trackWindow();
    }

    public WindowTrackingKey getCurrentWindowKey() {
        return new WindowTrackingKey(windowBeg, windowEnd);
    }

    public WindowTrackingValue<String> getCurrentWindowValue() {
        return windowTracker.get(getCurrentWindowKey());
    }

    public int getCurrentWindowValueCount() {
        WindowTrackingValue<String> val = getCurrentWindowValue();
        return windowValueCountTracker.get(val.value);
    }

    public boolean canMove() {
        if (windowBeg + windowSize - 1 < inp.length() && windowBeg < windowEnd) {
            return true;
        } else {
            return false;
        }
    }

    public int getNoOfWindows() {
        return windowTracker.size();
    }

    public int getNoOfUniqueWindowValues() {
        return windowTracker.size();
    }
}