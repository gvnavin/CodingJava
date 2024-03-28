package backtracking;

import java.util.Arrays;
import java.util.List;

import static utils.Print.repeat;

public class NQueenV0 {

    public static boolean check(int[][] grid, int i, int j) {
        for (int k = 0; k < grid.length; k++) {
            if (grid[k][j] == 1) {
                return false;
            }
        }
        for (int k = 0; k < grid[i].length; k++) {
            if (grid[i][k] == 1) {
                return false;
            }
        }

        int ii = i;
        int jj = j;
        while (ii >= 0 && jj >= 0) {
            if (grid[ii][jj] == 1) {
                return false;
            }
            ii--;
            jj--;
        }

        ii = i;
        jj = j;
        while (ii < grid.length && jj < grid[ii].length) {
            if (grid[ii][jj] == 1) {
                return false;
            }
            ii++;
            jj++;
        }

        ii = i;
        jj = j;
        while (ii >= 0 && jj < grid[ii].length) {
            if (grid[ii][jj] == 1) {
                return false;
            }
            ii--;
            jj++;
        }

        ii = i;
        jj = j;
        while (ii < grid.length && jj >= 0) {
            if (grid[ii][jj] == 1) {
                return false;
            }
            ii++;
            jj--;
        }

        return true;
    }

    public static boolean solveNQueensRec(int[][] grid, int i, int j, int cnt) {
        System.out.println("i = " + i + ", j = " + j + ", cnt = " + cnt);
        print(grid);
        if (i >= grid.length || j >= grid[i].length) {
            if (cnt == grid.length) {
                return true;
            } else {
                return false;
            }
        }

        for (int jj = 0; jj < grid.length; jj++) {
            if (check(grid, i, jj)) {
                grid[i][jj] = 1;
                boolean ret = solveNQueensRec(grid, i + 1, jj, cnt + 1);
                if (ret) {
                    return true;
                } else {
                    grid[i][jj] = 0;
                }
            }
        }

        return false;
    }

    private static void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int solveNQueens(int n) {

//        for (int i = 0; i < n; i++) {
        int[][] grid = new int[n][n];
//            grid[0][i] = 1;
        solveNQueensRec(grid, 0, 0, 0);
//        }

        return 0;
    }

    public static void main(String args[]) {
//        List<Integer> n = Arrays.asList(4, 5, 6, 7, 8);
        List<Integer> n = Arrays.asList(4);
        for (int i = 0; i < n.size(); i++) {
            System.out.println(i + 1 + ".\tQueens: " + n.get(i) + ", Chessboard: (" + n.get(i) + "x" + n.get(i) + ")");
            int res = solveNQueens(n.get(i));
            System.out.println("\n\tTotal solutions count for " + n.get(i) + " queens on a (" + n.get(i) + "x" + n.get(i) + ") chessboard: " + res);
            System.out.println(repeat("-", 100));
        }
    }

}