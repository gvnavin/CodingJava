package practice.dynamicprogramming.coinchange;

public class CoinChange {

    static class Node {
        int val;
        int cnt;

        public Node(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }

        public static Node valueOf(int val, int cnt) {
            return new Node(val, cnt);
        }
    }

    public static int coinChange(int[] coins, int total) {
        return recur(coins, total, 0).cnt;
    }

    public static Node recur(int[] coins, int total, int i) {

        if (total == 0) {
//            return
        }

        Node node1 = recur(coins, total, i + 1);
        Node node1ret = Node.valueOf(node1.val + coins[1], node1.cnt + 1);

        Node node2 = recur(coins, total, i + 1);
        Node node2ret = node2;

        Node node3 = recur(coins, total, i);
        Node node3ret = Node.valueOf(node1.val + coins[1], node1.cnt + 1);

//        if ()
        return null;
    }

}
