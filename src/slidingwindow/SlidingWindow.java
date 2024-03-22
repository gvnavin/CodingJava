package slidingwindow;

import java.util.*;

import static utils.Print.repeat;

public class SlidingWindow {
    public static double[] medianSlidingWindow(int[] nums, int k) {

        PriorityQueue<Integer> firstPartMaxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> secondPartMinHeap = new PriorityQueue<>(Comparator.naturalOrder());

        for (int i = 0; i < k; i++) {
            manage(nums, firstPartMaxHeap, i, secondPartMinHeap);
        }

        List<Double> medians = new ArrayList<>();
        int beg = 0;
        int end = k - 1;
        while (end < nums.length) {

            System.out.println("beg = " + beg);
            System.out.println("end = " + end);
            System.out.println("medians = " + medians);
            System.out.println("firstPartMaxHeap = " + firstPartMaxHeap);
            System.out.println("secondPartMinHeap = " + secondPartMinHeap);

            if (firstPartMaxHeap.size() == secondPartMinHeap.size()) {
                medians.add(firstPartMaxHeap.peek()/2.0d + secondPartMinHeap.peek()/2.0d);
            } else if (firstPartMaxHeap.size() > secondPartMinHeap.size()) {
                medians.add(firstPartMaxHeap.peek() * 1.0d);
            } else {
                medians.add(secondPartMinHeap.peek() * 1.0d);
            }

            if (firstPartMaxHeap.contains(nums[beg])) {
                firstPartMaxHeap.remove(Integer.valueOf(nums[beg]));
            } else {
                secondPartMinHeap.remove(Integer.valueOf(nums[beg]));
            }

            if (Math.abs(firstPartMaxHeap.size() - secondPartMinHeap.size()) > 1) {
                if (firstPartMaxHeap.size() > secondPartMinHeap.size()) {
                    secondPartMinHeap.add(firstPartMaxHeap.poll());
                } else {
                    firstPartMaxHeap.add(secondPartMinHeap.poll());
                }
            }

            beg ++;
            end ++;

            // if (beg < nums.length) {
            //    manage(nums, firstPartMaxHeap, beg, secondPartMinHeap);
            // }

            if (end < nums.length) {
                manage(nums, firstPartMaxHeap, end, secondPartMinHeap);
            }

        }

        double[] doubles = new double[medians.size()];
        for (int i = 0; i < medians.size(); i++) {
            doubles[i] = medians.get(i);
        }
        return doubles;
    }

    private static void manage(int[] nums, PriorityQueue<Integer> firstPartMaxHeap, int i, PriorityQueue<Integer> secondPartMinHeap) {
        if (firstPartMaxHeap.isEmpty()) {
            firstPartMaxHeap.add(nums[i]);
            return;
        }

        if (nums[i] < firstPartMaxHeap.peek()) {
            firstPartMaxHeap.add(nums[i]);
        } else {
            secondPartMinHeap.add(nums[i]);
        }

        if (Math.abs(firstPartMaxHeap.size() - secondPartMinHeap.size()) > 1) {
            if (firstPartMaxHeap.size() > secondPartMinHeap.size()) {
                secondPartMinHeap.add(firstPartMaxHeap.poll());
            } else {
                firstPartMaxHeap.add(secondPartMinHeap.poll());
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{3, 1, 2, -1, 0, 5, 8}, {1, 2}, {4, 7, 2, 21}, {22, 23, 24, 56, 76, 43, 121, 1, 2, 0, 0, 2, 3, 5}, {1, 1, 1, 1, 1}};
        int[] k = {4, 1, 2, 5, 2};
        for (int i = 0; i < k.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tInput array = " + Arrays.toString(arr[i]) + ", k = " + k[i]);
            double[] output = medianSlidingWindow(arr[i], k[i]);
            System.out.println("\tMedians = " + Arrays.toString(output));
            System.out.println(repeat("-", 100));
        }
    }
}
