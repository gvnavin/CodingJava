package practice.dynamicprogramming;

import java.util.Arrays;

public class Tribonacci {

    public static int findTribonacci(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return recur(n, memo);
    }

    private static int recur(int n, int[] memo) {
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        if (memo[n] != -1) {
            return memo[n];
        }

        int ret = recur(n -1, memo) + recur(n -2, memo) + recur(n -3, memo);
        memo[n] = ret;

        return memo[n];
    }

}
