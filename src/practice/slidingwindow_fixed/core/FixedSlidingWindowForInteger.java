package practice.slidingwindow_fixed.core;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class FixedSlidingWindowForInteger {

    int windowBeg = 0;
    int windowEnd = 0;
    private final int windowSize;
    private final int[] inp;

    HashMap<WindowTrackingKey, WindowTrackingValue<int[]>> windowTracker = new HashMap<>();

    FixedSizePriorityQueueForInteger pqMax;
    FixedSizePriorityQueueForInteger pqMin;

    public FixedSlidingWindowForInteger(int[] inp, int windowSize) {
        this.windowSize = windowSize;
        this.inp = inp;
        windowBeg = 0;
        windowEnd = windowSize - 1;
        pqMax = new FixedSizePriorityQueueForInteger(windowSize, Comparator.reverseOrder());
        pqMin = new FixedSizePriorityQueueForInteger(windowSize, Comparator.naturalOrder());
    }

    public void init() {
        trackWindow();
        WindowTrackingValue<int[]> currentWindowValue = getCurrentWindowValue();
        for (int i : currentWindowValue.value) {
            pqMax.add(i);
            pqMin.add(i);
        }
        currentWindowValue.max = pqMax.peek();
        currentWindowValue.min = pqMin.peek();
    }

    private void trackWindow() {
        int[] subArray = Arrays.copyOfRange(inp, windowBeg, windowEnd + 1);
        WindowTrackingKey key = getCurrentWindowKey();
        WindowTrackingValue<int[]> val = new WindowTrackingValue<>(subArray, windowBeg, windowEnd);
        windowTracker.put(key, val);
    }

    public void move() {
        int oldValue = inp[windowBeg];
        windowBeg++;
        windowEnd = Math.min(windowEnd + 1, inp.length - 1);
        int newValue = inp[windowEnd];
        trackWindow();
        WindowTrackingValue<int[]> currentWindowValue = getCurrentWindowValue();
        pqMax.removeAndAdd(oldValue, newValue);
        pqMin.removeAndAdd(oldValue, newValue);
        currentWindowValue.max = pqMax.peek();
        currentWindowValue.min = pqMin.peek();
    }

    public WindowTrackingKey getCurrentWindowKey() {
        return new WindowTrackingKey(windowBeg, windowEnd);
    }

    public WindowTrackingValue<int[]> getCurrentWindowValue() {
        return windowTracker.get(getCurrentWindowKey());
    }

    public boolean canMove() {
        return windowBeg + windowSize - 1 < inp.length && windowBeg <= windowEnd;
    }

    public int getNoOfWindows() {
        return windowTracker.size();
    }

    public int getNoOfUniqueWindowValues() {
        return windowTracker.size();
    }
}