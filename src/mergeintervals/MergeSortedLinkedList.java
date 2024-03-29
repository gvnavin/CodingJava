package mergeintervals;

import utils.LinkedList;
import utils.LinkedListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortedLinkedList {
    static class WrapperNode {
        int val;
        LinkedListNode node;

        public WrapperNode(int val, LinkedListNode node) {
            this.val = val;
            this.node = node;
        }
    }

    public static LinkedListNode mergeKLists(List<LinkedList<Integer>> lists) {

        PriorityQueue<WrapperNode> q = new PriorityQueue<>(Comparator.comparingInt(wrapperNode -> wrapperNode.val));

        for (LinkedList<Integer> list : lists) {
            q.add(new WrapperNode(list.head.data, list.head));
        }

        LinkedListNode head = null;
        LinkedListNode current = null;

        while(!q.isEmpty()) {
            WrapperNode wrapperNode = q.poll();
            LinkedListNode newNode = new LinkedListNode(wrapperNode.val);

            if (head == null) {
                head = newNode;
            }

            if (current != null) {
                current.next = newNode;
            }
            current = newNode;

            if (wrapperNode.node.next != null) {
                q.add(new WrapperNode(wrapperNode.node.next.data, wrapperNode.node.next));
            }
        }

        return head;
    }
}
