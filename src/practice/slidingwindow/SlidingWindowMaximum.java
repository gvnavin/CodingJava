package practice.slidingwindow;

import java.util.*;

class SlidingWindowMaximum {

    public static int[] findMaxSlidingWindow(int[] nums, int w) {

        w = Math.min(nums.length, w);

        int ret[] = new int[nums.length - (w-1)];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        int i=0;
        while(i < w) {
            pq.add(nums[i]);
            i++;
        }

        int beg = 0;
        int end = w-1;
        int j=0;

        while(end < nums.length) {
            ret[j] = pq.peek();
            j++;

            pq.remove(nums[beg]);
            beg++;
            end++;
            if (end < nums.length) {
                pq.add(nums[end]);
            }
        }

        return ret;
    }

}