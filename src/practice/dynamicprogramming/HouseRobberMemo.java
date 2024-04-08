package practice.dynamicprogramming;

import java.util.Arrays;

public class HouseRobberMemo {

    public static int houseRobber(int[] money) {

        int[] memo = new int[money.length];

        Arrays.fill(memo, -1);
        int includeFirst = recur(money, 0, money.length-1, memo);

        Arrays.fill(memo, -1);
        int includeLast = recur(money, 1, money.length, memo);

        return Math.max(includeFirst, includeLast);
    }

    public static int recur(int[] money, int i, int end, int[] memo) {
        if (i >= end) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        int include = money[i] + recur(money, i+2, end, memo);
        int exclude = recur(money, i+1, end, memo);

        int max = Math.max(include, exclude);
        memo[i] = max;
        return max;

    }

}
