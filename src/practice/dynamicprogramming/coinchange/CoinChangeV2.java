package practice.dynamicprogramming.coinchange;

import java.util.*;
public class CoinChangeV2 {
    static class Node {
        boolean found;
        int cnt;

        public Node(boolean found, int cnt) {
            this.found = found;
            this.cnt = cnt;
        }

        public static Node valueOf(boolean found, int cnt) {
            return new Node(found, cnt);
        }

        public static Node valueOf(boolean found) {
            return new Node(found, 0);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "found=" + found +
                    ", cnt=" + cnt +
                    '}';
        }
    }

    public static int coinChange(int[] coins, int total) {
        Node ret = recur(coins, total, 0);
        if (ret.found) {
            return ret.cnt;
        }
        return -1;
    }

    public static Node recur(int[] coins, int total, int i) {

        if (i >= coins.length || total < 0) {
            return Node.valueOf(false);
        }

        if (total == 0) {
            return Node.valueOf(true);
        }

        Node c1 = recur(coins, total, i + 1);
        Node c2 = recur(coins, total - coins[i], i + 1);
        Node c3 = recur(coins, total - coins[i], i);

        List<Node> rets = new ArrayList<>();

        if (c1.found) {
            rets.add(c1);
        }

        if (c2.found) {
            c2.cnt++;
            rets.add(c2);
        }

        if (c3.found) {
            c3.cnt++;
            rets.add(c3);
        }

        if (rets.isEmpty()) {
            return Node.valueOf(false);
        }

        System.out.println("rets = " + rets);

        Node min = rets.get(0);

        for (int j=1; j < rets.size(); j++) {
            if (rets.get(j).cnt < min.cnt) {
                System.out.println("rets.get(j) = " + rets.get(j));
                min = rets.get(j);
            }
        }

//        List<Node> allChoices = List.of(c1, c2, c3);
//        Node node = allChoices.stream().filter(it -> it.found).min(Comparator.comparingInt(it->it.cnt)).get();

        return min;

    }
}