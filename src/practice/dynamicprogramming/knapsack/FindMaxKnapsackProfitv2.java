package practice.dynamicprogramming.knapsack;

import java.util.Arrays;

public class FindMaxKnapsackProfitv2 {
    public static int findMaxKnapsackProfit(int capacity, int[] weights, int[] values) {
        int[][] memo = new int[weights.length][capacity + 1];
        for (int i = 0; i < weights.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return recur(capacity, weights, values, 0, memo);
    }

    public static int recur(int capacity, int[] weights, int[] values, int i, int[][] memo) {

        if (capacity == 0 || i == weights.length) {
            return 0;
        }

        if (memo[i][capacity] != -1) {
            return memo[i][capacity];
        }

        int withCurrent = 0;
        if (weights[i] <= capacity) {
            withCurrent = values[i] + recur(capacity - weights[i], weights, values, i + 1, memo);
        }
        int withoutCurrent = recur(capacity, weights, values, i + 1, memo);

        memo[i][capacity] = Math.max(withCurrent, withoutCurrent);
        return memo[i][capacity];

    }
}
