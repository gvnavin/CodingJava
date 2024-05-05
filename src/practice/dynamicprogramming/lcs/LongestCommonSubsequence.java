package practice.dynamicprogramming.lcs;

public class LongestCommonSubsequence {

    public static int longestCommonSubsequence(String str1, String str2) {
        return recur(str1, str2, 0, 0);
    }

    public static int recur(String str1, String str2, int i, int j) {
        if (i >= str1.length() || j >= str2.length()) {
            return 0;
        }

        if (str1.charAt(i) == str2.charAt(j)) {
            return 1 + recur(str1, str2, i + 1, j + 1);
        } else {
            int choice1 = recur(str1, str2, i, j + 1);
            int choice2 = recur(str1, str2, i + 1, j);
            return Math.max(choice1, choice2);
        }
    }

}
