package practice.slidingwindow_fixed;

import practice.slidingwindow_fixed.core.FixedSlidingWindowForString;
import practice.slidingwindow_fixed.core.WindowTrackingValue;

import java.util.*;

public class FindRepeatedSequences {

    public static Set<String> findRepeatedSequences(String s, int k) {

        FixedSlidingWindowForString fixedSlidingWindowForString = new FixedSlidingWindowForString(s, k);
        fixedSlidingWindowForString.init();

        Set<String> ret = new HashSet<>();

        while (fixedSlidingWindowForString.canMove()) {
            WindowTrackingValue<String> currentWindowValue = fixedSlidingWindowForString.getCurrentWindowValue();
            String windowSubString = currentWindowValue.getValue();
            int count = fixedSlidingWindowForString.getCurrentWindowValueCount();
            if (count > 1) {
                ret.add(windowSubString);
            }
            fixedSlidingWindowForString.move();
        }

        return ret;
    }
}