package topkelements;

import java.util.*;

public class ReorganizeString {

    static class Node {
        char c;
        int cnt;

        public Node(char c, int cnt) {
            this.c = c;
            this.cnt = cnt;
        }

        public Node(char c) {
            this.c = c;
            this.cnt = 0;
        }
    }

    public static String reorganizeString(String inp) {

        PriorityQueue<Node> q = new PriorityQueue<>((n1, n2) -> n2.cnt-n1.cnt);
        HashMap<Character, Node> hm = new HashMap<>();

        for (int i = 0; i < inp.length(); i++) {
            char c = inp.charAt(i);
            Node node = hm.getOrDefault(c, new Node(c));
            node.cnt++;
            hm.put(c, node);
        }

        for (Node n : hm.values()) {
            q.add(n);
        }

        StringBuilder sb = new StringBuilder();
        Node previous = null;

        while (!q.isEmpty()) {
            Node node = q.poll();
            sb.append(node.c);

            node.cnt--;

            if (previous != null && previous.cnt > 0) {
                q.add(previous);
            }
            previous = node;

        }

        for (Node n : hm.values()) {
            if(n.cnt > 0) {
                return "";
            }
        }

        return sb.toString();
    }
}
