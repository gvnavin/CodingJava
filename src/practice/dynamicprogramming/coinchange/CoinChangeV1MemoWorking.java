package practice.dynamicprogramming.coinchange;

import java.util.Arrays;

public class CoinChangeV1MemoWorking {

    public static int coinChange(int[] coins, int total) {
        int[][] memo = new int[coins.length][total + 1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(memo[i], -1);
        }

        int ret = recur(coins, total, 0, memo);
        if (ret < 0 || ret == Integer.MAX_VALUE/2) {
            ret = -1;
        }

        return ret;
    }

    public static int recur(int[] coins, int total, int i,  int[][] memo) {

        if (i >= coins.length || total < 0) {
            return Integer.MAX_VALUE/2;
        }

        if (total == 0) {
            return 0;
        }

        if (memo[i][total] != -1) {
            return memo[i][total];
        }

        int c1 = recur(coins, total, i + 1, memo);
        int c2 = 1 + recur(coins, total - coins[i], i + 1, memo);
        int c3 = 1 + recur(coins, total - coins[i], i, memo);

        System.out.println("c1 = " + c1 + " c2 = " + c2 + " c3 = " + c3);

        int ret = Math.min(Math.min(c1, c2), c3);

        memo[i][total] = ret;

        return memo[i][total];

    }
}
