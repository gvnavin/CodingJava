package practice.graphs;

import java.util.*;

public class MinimumBuses {

    static class StationToBus {
        int stationId;
        List<Integer> busIds = new ArrayList<>();

        public StationToBus(int stationId) {
            this.stationId = stationId;
        }

        public void addBus(int busId) {
            busIds.add(busId);
        }
    }

    static class Node {
        StationToBus stationToBus;
        Set<Integer> busesTaken = new HashSet<>();

        public Node(StationToBus stationToBus) {
            this.stationToBus = stationToBus;

        }

        public void addBusTaken(Integer busId) {
            busesTaken.add(busId);
        }

        public void addAllBusTaken(Set<Integer> busesTaken) {
            this.busesTaken.addAll(busesTaken);
        }
    }

    public static int minimumBuses(int[][] busRoutes, int src, int dest) {

        HashMap<Integer, StationToBus> stationToBusMap = new HashMap<>();
        for (int i = 0; i < busRoutes.length; i++) {
            int busId = i;
            for (int j = 0; j < busRoutes[i].length; j++) {
                int stationId = busRoutes[i][j];
                StationToBus stationToBus = stationToBusMap.getOrDefault(stationId, new StationToBus(stationId));
                stationToBus.busIds.add(busId);
                stationToBusMap.put(stationId, stationToBus);
            }
        }

        Queue<Node> q = new ArrayDeque<>();
        StationToBus source = stationToBusMap.get(src);
        q.add(new Node(source));

        Set<Integer> visitedStations = new HashSet<>();

        while (!q.isEmpty()) {
            Node localNode = q.poll();

            if (visitedStations.contains(localNode.stationToBus.stationId)) {
                continue;
            }

            visitedStations.add(localNode.stationToBus.stationId);

            if (localNode.stationToBus.stationId == dest) {
                return localNode.busesTaken.size();
            }

            for (Integer busId : localNode.stationToBus.busIds) {
                int[] stations = busRoutes[busId];
                for (int stationId : stations) {
                    StationToBus stationToBus1 = stationToBusMap.get(stationId);
                    Node nextNode = new Node(stationToBus1);
                    nextNode.addAllBusTaken(localNode.busesTaken);
                    nextNode.addBusTaken(busId);
                    q.add(nextNode);
                }
            }
        }

        return -1;
    }

    // Driver code
    public static void main(String[] args) {
        int[][][] routes = {
                {{2, 5, 7}, {4, 6, 7}},
                {{1, 12}, {4, 5, 9}, {9, 19}, {10, 12, 13}},
                {{1, 12}, {10, 5, 9}, {4, 19}, {10, 12, 13}},
                {{1, 9, 7, 8}, {3, 6, 7}, {4, 9}, {8, 2, 3, 7}, {2, 4, 5}},
                {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
        };
        int[] src = {2, 9, 1, 1, 4};
        int[] dest = {6, 12, 9, 5, 6};

        for (int i = 0; i < routes.length; i++) {
            System.out.print((i + 1) + ".\tBus Routes: ");
            System.out.print(Arrays.deepToString(routes[i]));
            System.out.println();
            System.out.println("\tSource: " + src[i]);
            System.out.println("\tDestination: " + dest[i]);
            System.out.println("\n\tMinimum Buses Required: " + minimumBuses(routes[i], src[i], dest[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
