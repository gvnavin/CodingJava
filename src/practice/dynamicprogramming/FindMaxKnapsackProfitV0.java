package practice.dynamicprogramming;

public class FindMaxKnapsackProfitV0 {
    public static int findMaxKnapsackProfit(int capacity, int [] weights, int [] values) {
        return recur(capacity, weights, values, 0, 0, 0);
    }

    public static int recur(int capacity, int [] weights, int [] values, int i, int weightTillNow, int valueTillNow) {

        if (weightTillNow == capacity) {
            return valueTillNow;
        }

        if (i >= weights.length) {
            return valueTillNow;
        }

        int weight = weightTillNow + weights[i];
        int value = valueTillNow + values[i];

        int l = 0;
        if (weight <= capacity) {
            l = recur(capacity, weights, values, i + 1, weight, value);
        }
        int r = recur(capacity, weights, values, i+1, weightTillNow, valueTillNow);

        return Math.max(l, r);

    }
}
