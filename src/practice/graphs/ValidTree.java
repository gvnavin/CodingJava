package practice.graphs;

import java.util.*;

public class ValidTree {

    static class Node {
        int id;
        List<Node> neighbours = new ArrayList<>();

        public Node(int id) {
            this.id = id;
        }
    }

    public static boolean validTree(int n, int[][] edges) {

        if (edges.length != n-1) {
            return false;
        }

        Map<Integer, Node> mapOfIdToNode = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            Node node1 = mapOfIdToNode.getOrDefault(edges[i][0], new Node(edges[i][0]));
            Node node2 = mapOfIdToNode.getOrDefault(edges[i][1], new Node(edges[i][1]));
            node1.neighbours.add(node2);
            node2.neighbours.add(node1);

            mapOfIdToNode.put(edges[i][0], node1);
            mapOfIdToNode.put(edges[i][1], node2);
        }

        Node node = mapOfIdToNode.get(0);
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);

        Set<Integer> visited = new HashSet<>();

        while(!q.isEmpty()) {
            Node localNode = q.poll();
            if (visited.contains(localNode.id)) {
                continue;
            }

            visited.add(localNode.id);

            for (Node neighbour : localNode.neighbours) {
                q.add(neighbour);
            }
        }

        if (visited.size() == n) {
            return true;
        }

        return false;
    }

    // Driver code
    public static void main(String[] args) {
        int[] n = {5, 3, 4, 5, 6};
        int[][][] edges = {
                {{0, 1}, {0, 2}, {0, 3}, {3, 4}},
                {{0, 1}, {0, 2}, {1, 2}},
                {{0, 1}, {0, 2}, {0, 3}},
                {{0, 1}, {0, 2}, {0, 3}, {0, 4}, {3, 4}},
                {{0, 1}, {0, 2}, {1, 3}, {2, 4}, {0, 5}}
        };

        for (int i = 0; i < n.length; i++) {
            System.out.println((i + 1) + ". n = " + n[i]);
            System.out.println("   Edges = " + Arrays.deepToString(edges[i]));
            System.out.println("   Is the given graph a valid tree: " + validTree(n[i], edges[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
