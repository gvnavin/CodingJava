package practice.dynamicprogramming;

public class UpdateMatrixV1 {

    public static int[][] updateMatrix(int[][] mat) {

        int[][] dp = new int[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                dp[i][j] = Integer.MAX_VALUE - 10000;
            }
        }

        if(mat[0][0] == 1) {
            dp[0][0] = Integer.MAX_VALUE - 10000;
        } else {
            dp[0][0] = 0;
        }

        //top
        for (int i = 1; i < mat.length; i++) {
            if (mat[i][0] == 1) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][0]) + 1;
            } else {
                dp[i][0] = 0;
            }
        }

        //left
        for (int i = 1; i < mat[0].length; i++) {
            if (mat[0][i] == 1) {
                dp[0][i] = Math.min(dp[0][i], dp[0][i - 1]) + 1;
            } else {
                dp[0][i] = 0;
            }
        }

        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }

//        if(mat[0][0] == 1) {
//            dp[0][0] = Integer.MAX_VALUE - 10000;
//        }

        //down
        int x = mat[0].length - 1;
        for (int i = mat.length - 2; i >= 0; i--) {
            if (mat[i][x] == 1) {
                dp[i][x] = Math.min(dp[i][x], dp[i + 1][x] + 1);
            } else {
                dp[i][x] = 0;
            }
        }

        //right
        int y = mat.length - 1;
        for (int i = mat[0].length - 2; i >= 0; i--) {
            if (mat[y][i] == 1) {
                dp[y][i] = Math.min(dp[y][i], dp[y][i + 1] + 1);
            } else {
                dp[y][i] = 0;
            }
        }

        for (int i = mat.length - 2; i >= 0; i--) {
            for (int j = mat[i].length - 2; j >= 0; j--) {
                if (mat[i][j] == 1) {
                    System.out.println("i = " + i + ", j = " + j + " dp[i + 1][j] + 1 : " + dp[i + 1][j] + 1 + " dp[i][j + 1]) + 1 : " + dp[i][j + 1] + 1);
                    int min = Math.min(dp[i + 1][j] + 1, dp[i][j + 1] + 1);
                    System.out.println("dp[i][j] = " + dp[i][j] + ", min = " + min);
                    dp[i][j] = Math.min(dp[i][j], min);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return dp;
    }

}
