package practice.dynamicprogramming;

public class CountPalindromicSubstrings {

    public static int countPalindromicSubstrings(String s) {

        boolean[][] dp = new boolean[s.length()][s.length()];

        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            cnt ++;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i+1] = true;
                cnt ++;
            }
        }

        for (int l = 3; l <= s.length(); l++) {
            for (int i = 0, j = l-1; j < s.length(); i++, j++) {
                if (dp[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    cnt++;
                }
            }
        }

        return cnt;
    }

}
