package practice.graphs;

import java.util.*;

public class CloneGraph {

    static class Node {
        int data;
        List<Node> neighbors;

        public Node(int data) {
            this.data = data;
            this.neighbors = new ArrayList<Node>();
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", neighbors=" + neighbors +
                    '}';
        }
    }

    static class ExtNode {
        Node node;
        Node parent;

        public ExtNode(Node node, Node parent) {
            this.node = node;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "ExtNode{" +
                    "node=" + node +
                    ", parent=" + parent +
                    '}';
        }
    }

    public static Node clone(Node root) {

        Queue<ExtNode> q = new ArrayDeque<>();
        q.add(new ExtNode(root, null));

        Node newRoot = null;

        Set<String> visited = new HashSet<>();

        Map<Integer, Node> nodesCreated = new HashMap<>();

        while(!q.isEmpty()) {

            ExtNode existingExtNode = q.poll();

            System.out.println("existingExtNode = " + existingExtNode);

            Node existingNode = existingExtNode.node;

            String keyEdge = existingExtNode.parent + "|" + existingNode.data;
            if (visited.contains(keyEdge)) {
                continue;
            }

            visited.add(keyEdge);

            Node newNode = nodesCreated.getOrDefault(existingNode.data, new Node(existingNode.data));
            nodesCreated.put(existingNode.data, newNode);

            if (newRoot == null) {
                newRoot = newNode;
            } else {
                System.out.println("existingExtNode.parent = " + existingExtNode.parent);
                existingExtNode.parent.neighbors.add(newNode);
            }

            for (Node neighbor : existingNode.neighbors) {
                q.add(new ExtNode(neighbor, newNode));
            }

        }

        return newRoot;
    }
}
