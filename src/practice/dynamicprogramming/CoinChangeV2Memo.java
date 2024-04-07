package practice.dynamicprogramming;

import java.util.*;
public class CoinChangeV2Memo {


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
        Node[][] memo = new Node[coins.length][total + 1];
        Node ret = recur(coins, total, 0, memo);
        if (ret.found) {
            return ret.cnt;
        }
        return -1;
    }

    public static Node recur(int[] coins, int total, int i, Node[][] memo) {

        if (i >= coins.length || total < 0) {
            return Node.valueOf(false);
        }

        if (total == 0) {
            return Node.valueOf(true);
        }

        // System.out.println("memo[i][total] : " + memo[i][total]);

        if (memo[i][total] != null) {
            return memo[i][total];
        }

        Node c1 = recur(coins, total, i + 1, memo);
        Node c2 = recur(coins, total - coins[i], i + 1, memo);
        Node c3 = recur(coins, total - coins[i], i, memo);

        List<Node> rets = new ArrayList<>();

        if (c1.found) {
            rets.add(c1);
        }

        if (c2.found) {
            rets.add(Node.valueOf(true, c2.cnt+1));
        }

        if (c3.found) {
            rets.add(Node.valueOf(true, c3.cnt+1));
        }

        if (rets.isEmpty()) {
            memo[i][total] = Node.valueOf(false);;
            return memo[i][total];
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

        memo[i][total] = min;

        return memo[i][total];

    }
}