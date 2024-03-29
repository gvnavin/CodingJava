package topkelements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class ReorganizeStringV0 {

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
        List<Node> nodes = new ArrayList<>();
        while (!q.isEmpty()) {
            Node node = q.poll();
            sb.append(node.c);
            node.cnt--;

            if (node.cnt > 0) {
                nodes.add(node);
            }
        }

        int i = 0;
        while(!nodes.isEmpty()) {
            Node node = nodes.get(i);
            if (sb.charAt(sb.length()-1) != node.c) {
                sb.append(node.c);
            } else {
                return "";
            }
            node.cnt--;
            if (node.cnt <= 0) {
                nodes.remove(i);
                if (!nodes.isEmpty() && i >= nodes.size()) {
                    i = (i + 1) % nodes.size();
                }
            } else {
                i = (i + 1) % nodes.size();
            }
        }

        return sb.toString();
    }
}
