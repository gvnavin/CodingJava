package practice.slidingwindow_fixed.core;


public class WindowTrackingValue<T> {
    T value;
    public int sum, max, min;
    private final int windowBeg;
    private final int windowEnd;

    public WindowTrackingValue(T value, int windowBeg, int windowEnd) {
        this.value = value;
        this.windowBeg = windowBeg;
        this.windowEnd = windowEnd;
    }

    public T getValue() {
        return value;
    }
}