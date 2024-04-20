package practice.slidingwindow_fixed.core;

import java.util.Objects;

public class WindowTrackingKey {

    int windowBeg = 0;
    int windowEnd = 0;

    public WindowTrackingKey(int windowBeg, int windowEnd) {
        this.windowBeg = windowBeg;
        this.windowEnd = windowEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WindowTrackingKey that = (WindowTrackingKey) o;
        return windowBeg == that.windowBeg && windowEnd == that.windowEnd;
    }

    @Override
    public int hashCode() {
        return Objects.hash(windowBeg, windowEnd);
    }
}