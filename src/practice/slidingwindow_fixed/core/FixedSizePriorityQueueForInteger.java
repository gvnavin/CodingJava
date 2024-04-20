package practice.slidingwindow_fixed.core;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FixedSizePriorityQueueForInteger extends PriorityQueue<Integer> {

    private final int size;

    public FixedSizePriorityQueueForInteger(int size,
                                            Comparator<Integer> comparator) {
        super(size, comparator);
        this.size = size;
    }

    public boolean add(Integer integer) {
        if (this.size() >= size) {
            throw new IllegalArgumentException("Heap is full");
        }
        return super.add(integer);
    }

    public void removeAndAdd(Integer toRemove, Integer toAdd) {
        this.remove(toRemove);
        this.add(toAdd);
    }
}
