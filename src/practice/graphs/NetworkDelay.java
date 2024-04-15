package practice.graphs;

import java.util.*;

public class NetworkDelay {
    static class Node implements Comparable<Node> {

        int id;
        List<Integer> neighbours = new ArrayList<>();
        List<Integer> times = new ArrayList<>();
        int timeToReach = 0;

        public Node(int id) {
            this.id = id;
        }

        public Node(Node other) {
            this.id = other.id;
            this.neighbours = new ArrayList<>(other.neighbours);  // Create a copy of neighbours list
            this.times = new ArrayList<>(other.times);          // Create a copy of times list
            this.timeToReach = other.timeToReach;
        }

        public void add(int neighbour, int time) {
            this.neighbours.add(neighbour);
            this.times.add(time);
        }

        public Integer getNeighbour(int i) {
            return neighbours.get(i);
        }

        public Integer getTime(int i) {
            return times.get(i);
        }

        public void addTimeToReach(int time) {
            this.timeToReach = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.timeToReach - o.timeToReach;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return id == node.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +
                    ", neighbours=" + neighbours +
                    ", times=" + times +
                    ", timeToReach=" + timeToReach +
                    '}';
        }
    }

    public static int networkDelayTime(int[][] times, int n, int k) {

        HashMap<Integer, Node> mp = new HashMap<>();

        for (int i = 0; i < times.length; i++) {
            Node node = mp.getOrDefault(times[i][0], new Node(times[i][0]));
            node.add(times[i][1], times[i][2]);
            mp.put(times[i][0], node);

            Node neighbour = mp.getOrDefault(times[i][1], new Node(times[i][1]));
            mp.put(times[i][1], neighbour);
        }

        Node startingNode = mp.get(k);
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(node->node.timeToReach));
        q.add(startingNode);

        HashMap<Integer, Boolean> visitedMap = new HashMap<>();

        int visitedCnt = 0;

        int max = -1;

        while (!q.isEmpty()) {

            Node localNode = q.poll();

            if (visitedMap.containsKey(localNode.id)) {
                continue;
            }

            visitedMap.put(localNode.id, true);
            visitedCnt += 1;

            max = Math.max(max, localNode.timeToReach);

            System.out.println("localNode = " + localNode);
            for (int i = 0; i < localNode.neighbours.size(); i++) {
                Integer neighbour = localNode.getNeighbour(i);
                Integer time = localNode.getTime(i);
                Node node = new Node(mp.get(neighbour));
                node.addTimeToReach(localNode.timeToReach + time);
                System.out.println("node = " + node);
                mp.put(neighbour, node);
                q.add(node);
            }
            System.out.println("----------------------");

        }

        if (visitedCnt == n) {
            return max;
        }

        return -1;
    }

}
