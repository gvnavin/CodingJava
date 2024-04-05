package practice.twoheaps;

import java.util.Comparator;
import java.util.PriorityQueue;

import static practice.utils.Print.repeat;

public class MedianOfStream {

    PriorityQueue<Integer> firstPartMaxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> secondPartMinHeap = new PriorityQueue<>(Comparator.naturalOrder());

    public MedianOfStream() {

    }

    public void insertNum(int num) {
        if (firstPartMaxHeap.isEmpty()) {
            firstPartMaxHeap.add(num);
            return;
        }

        if (num > firstPartMaxHeap.peek()) {
            secondPartMinHeap.add(num);
        } else {
            firstPartMaxHeap.add(num);
        }

        if (Math.abs(firstPartMaxHeap.size()-secondPartMinHeap.size()) > 1 ) {
            if (firstPartMaxHeap.size() > secondPartMinHeap.size()) {
                Integer poll = firstPartMaxHeap.poll();
                secondPartMinHeap.add(poll);
            } else {
                Integer poll = secondPartMinHeap.poll();
                firstPartMaxHeap.add(poll);
            }
        }

    }

    public double findMedian() {

        if (firstPartMaxHeap.size() == secondPartMinHeap.size()) {
            return (firstPartMaxHeap.peek() + secondPartMinHeap.peek())/2.0d;
        }

        if (firstPartMaxHeap.size() > secondPartMinHeap.size()) {
            return firstPartMaxHeap.peek();
        } else {
            return secondPartMinHeap.peek();
        }

    }

    public static void main(String[] args) {
        // Driver code
        int[] nums = {35, 22, 30, 25, 1};
        MedianOfStream medianOfAges = null;
        for(int i=0; i< nums.length; i++){
            System.out.print(i+1);
            System.out.print(".\tData stream: [");
            medianOfAges = new MedianOfStream();
            for(int j=0; j<=i; j++){
                System.out.print(nums[j]);
                if(j != i)
                    System.out.print(", ");
                medianOfAges.insertNum(nums[j]);
            }
            System.out.println("]");
            System.out.println("\tThe median for the given numbers is: " + medianOfAges.findMedian());
            System.out.println(repeat("-", 100));
        }

    }
}
