package topkelements;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int num : nums) {
            if (q.size() < k) {
                q.add(num);
                continue;
            }

            if (q.peek() < num) {
                q.poll();
                q.add(num);
            }

        }
        return q.peek();
    }
}
