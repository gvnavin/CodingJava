package practice.dynamicprogramming;

import java.util.Arrays;

public class PartitionEqualSumMemo {

    public static boolean canPartitionArray(int[] arr) {

        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        if (sum % 2 == 1) {
            return false;
        }

        int total = sum / 2;
        int[][] memo = new int[arr.length][total + 1];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return recur(arr, total, 0, memo);

    }

    private static boolean recur(int[] arr, int total, int i, int[][] memo) {

        if (total == 0) {
            return true;
        }

        if (i >= arr.length || total < 0) {
            return false;
        }

        if (memo[i][total] != -1) {
            return memo[i][total] == 1;
        }

        boolean include = recur(arr, total - arr[i], i + 1, memo);
        boolean exclude = recur(arr, total, i + 1, memo);

        boolean ret = include || exclude;
        memo[i][total] = ret ? 1 : 0;
        return ret;
    }

}
