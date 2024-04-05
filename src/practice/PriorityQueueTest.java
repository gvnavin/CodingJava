package practice;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());

        // Adding items to our priority queue
        // using add() method
        pQueue.add(10);
        pQueue.add(30);
        pQueue.add(20);
        pQueue.add(400);
        pQueue.add(400);

        pQueue.remove(400);

        pQueue.peek();
        pQueue.poll();

        Iterator itr = pQueue.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());

    }

}
