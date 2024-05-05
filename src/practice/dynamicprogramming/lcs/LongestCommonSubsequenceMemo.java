package practice.dynamicprogramming.lcs;

import java.util.Arrays;

public class LongestCommonSubsequenceMemo {

    public static int longestCommonSubsequence(String str1, String str2) {

        int[][] memo = new int[str1.length()][str2.length()];
        for (int i = 0; i < str1.length(); i++) {
            Arrays.fill(memo[i], -1);
        }

        return recur(str1, str2, 0, 0, memo);
    }

    public static int recur(String str1, String str2, int i, int j, int[][] memo) {
        if (i >= str1.length() || j >= str2.length()) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (str1.charAt(i) == str2.charAt(j)) {
            int ret = 1 + recur(str1, str2, i + 1, j + 1, memo);
            memo[i][j] = ret;
        } else {
            int choice1 = recur(str1, str2, i + 1, j, memo);
            int choice2 = recur(str1, str2, i, j + 1, memo);
            int ret = Math.max(choice1, choice2);
            memo[i][j] = ret;
        }

        return memo[i][j];
    }

}
