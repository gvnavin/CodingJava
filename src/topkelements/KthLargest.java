package topkelements;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargest {

    PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.naturalOrder());
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            heapify(num);
        }

    }

    private Integer heapify(int num) {
        if (q.size() < k) {
            q.add(num);
            return null;
        }

        if (num > q.peek()) {
            Integer poll = q.poll();
            q.add(num);
        }
        return q.peek();

    }

    // adds element in the topKHeap
    public int add(int val) {
        return heapify(val);
    }
}
