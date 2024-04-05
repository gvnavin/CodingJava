package practice.topkelements;

import java.util.*;

public class FrequentElements {

    public static class Node {
        public int val, cnt;

        public Node(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }
    }

    public static List<Integer> topKFrequent(int[] arr, int k) {

        HashMap<Integer, Integer> integerToCountMap = new HashMap<>();

        for (int i : arr) {
            int cnt = integerToCountMap.getOrDefault(i, 0);
            integerToCountMap.put(i, cnt+1);
        }

        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(o->o.cnt));

        for (Map.Entry<Integer, Integer> entry : integerToCountMap.entrySet()) {
            if (q.size() < k) {
                q.add(new Node(entry.getKey(), entry.getValue()));
                continue;
            }

            if (q.peek().cnt < entry.getValue()) {
                q.poll();
                q.add(new Node(entry.getKey(), entry.getValue()));
            }

        }

        List<Integer> ret = new ArrayList<>();
        for (Node node : q) {
            ret.add(node.val);
        }

        return ret;
    }
}
