package practice.dynamicprogramming;

public class UpdateMatrixV2 {

    public static int[][] updateMatrix(int[][] mat) {

        int[][] dp = new int[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {

                if (mat[i][j] == 1) {
                    int top = i > 0 ? dp[i - 1][j] : Integer.MAX_VALUE - 10000;
                    int left = j > 0 ? dp[i][j - 1] : Integer.MAX_VALUE - 10000;

                    dp[i][j] = Math.min(top, left) + 1;
                }
            }
        }

        for (int i = mat.length - 1; i >= 0; i--) {
            for (int j = mat[i].length - 1; j >= 0; j--) {
                if (mat[i][j] == 1) {
                    int down = i < mat.length - 1 ? dp[i+1][j] : Integer.MAX_VALUE - 10000;
                    int right =  j < mat[i].length - 1 ? dp[i][j+1] : Integer.MAX_VALUE - 10000;

                    dp[i][j] = Math.min(dp[i][j], Math.min(down + 1, right + 1));
                }
            }
        }

        return dp;
    }

}
