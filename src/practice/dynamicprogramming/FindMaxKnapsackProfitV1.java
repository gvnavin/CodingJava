package practice.dynamicprogramming;

public class FindMaxKnapsackProfitV1 {
    public static int findMaxKnapsackProfit(int capacity, int[] weights, int[] values) {
        return recur(capacity, weights, values, 0);
    }

    public static int recur(int capacity, int[] weights, int[] values, int i) {

        if (capacity == 0 || i == weights.length) {
            return 0;
        }

        int withCurrent = 0;
        if (weights[i] <= capacity) {
            withCurrent = values[i] + recur(capacity - weights[i], weights, values, i + 1);
        }
        int withoutCurrent = recur(capacity, weights, values, i + 1);

        return Math.max(withCurrent, withoutCurrent);

    }
}
