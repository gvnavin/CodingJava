package mergeksorted;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindSmallestNumber {

    static class Node {
        int i,j,val;

        public Node(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }

    public static int kSmallestNumber(List<List<Integer>> lists, int k) {

//        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o2.val-o1.val);
//        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.val-o2.val);
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for (int i = 0; i < lists.size(); i++) {
            if (!lists.get(i).isEmpty()) {
                q.add(new Node(i, 0, lists.get(i).get(0)));
            }
        }

        int ithSmallest = 0;
        int value = 0;
        while(!q.isEmpty()) {
            Node node = q.poll();
            value = node.val;
            ithSmallest++;
            if (ithSmallest == k) {
                return node.val;
            }
            if (node.j+1 < lists.get(node.i).size()) {
                Integer val = lists.get(node.i).get(node.j + 1);
                q.add(new Node(node.i, node.j+1, val));
            }

        }

        return value;
    }
}
