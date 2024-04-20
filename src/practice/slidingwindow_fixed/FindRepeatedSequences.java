package practice.slidingwindow_fixed;

import practice.slidingwindow_fixed.core.FixedSlidingStringWindow;
import practice.slidingwindow_fixed.core.WindowTrackingValue;

import java.util.*;

public class FindRepeatedSequences {

    public static Set<String> findRepeatedSequences(String s, int k) {

        FixedSlidingStringWindow fixedSlidingStringWindow = new FixedSlidingStringWindow(s, k);
        fixedSlidingStringWindow.init();

        Set<String> ret = new HashSet<>();

        while (fixedSlidingStringWindow.canMove()) {
            WindowTrackingValue<String> currentWindowValue = fixedSlidingStringWindow.getCurrentWindowValue();
            String windowSubString = currentWindowValue.getValue();
            int count = fixedSlidingStringWindow.getCurrentWindowValueCount();
            if (count > 1) {
                ret.add(windowSubString);
            }
            fixedSlidingStringWindow.move();
        }

        return ret;
    }
}