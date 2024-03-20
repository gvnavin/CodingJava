package backtracking;

import java.util.*;

import static utils.Print.repeat;

public class NQueen {

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

    public static int solveNQueensRec(int[][] grid, int i, int noOfQueensPlaced, ArrayList<int[][]> grids) {
//        System.out.println("i = " + i + ", noOfQueensPlaced = " + noOfQueensPlaced);
//        print(grid);
        if (i >= grid.length) {
            if (noOfQueensPlaced == grid.length) {
                grids.add(grid.clone());
//                print(grid);
                return 1;
            } else {
                return 0;
            }
        }

        int possibleOptions = 0;
        for (int jj = 0; jj < grid.length; jj++) {
            if (check(grid, i, jj)) {
                grid[i][jj] = 1;
                int ret = solveNQueensRec(grid, i + 1, noOfQueensPlaced + 1, grids);
                if (ret > 0) {
                    possibleOptions += ret;
                }
                grid[i][jj] = 0;
            }
        }

        return possibleOptions;
    }

    public static int solveNQueens(int n) {

        ArrayList<int[][]> grids = new ArrayList<>();
        int[][] grid = new int[n][n];
        int cnt = solveNQueensRec(grid, 0, 0,  grids);
        System.out.println("cnt = " + cnt);

//        not printing correctly since grids are getting reassigned to zeros
//        for (int i = 0; i < grids.size(); i++) {
//            print(grids.get(i));
//        }

        return cnt;
    }

    private static void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
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
