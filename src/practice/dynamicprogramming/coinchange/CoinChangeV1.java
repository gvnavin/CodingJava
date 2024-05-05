package practice.dynamicprogramming.coinchange;

public class CoinChangeV1 {

    public static int coinChange(int[] coins, int total) {
        int ret = recur(coins, total, 0);
        if (ret < 0 || ret == Integer.MAX_VALUE/2) {
            ret = -1;
        }

        return ret;
    }

    public static int recur(int[] coins, int total, int i) {

        if (i >= coins.length || total < 0) {
            return Integer.MAX_VALUE/2;
        }

        if (total == 0) {
            return 0;
        }

        int c1 = recur(coins, total, i + 1);
        int c2 = 1 + recur(coins, total - coins[i], i + 1);
        int c3 = 1 + recur(coins, total - coins[i], i);

        System.out.println("c1 = " + c1 + " c2 = " + c2 + " c3 = " + c3);

        int ret = Math.min(Math.min(c1, c2), c3);


        return ret;

    }
}
