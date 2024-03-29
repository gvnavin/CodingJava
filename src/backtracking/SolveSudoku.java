package backtracking;

import java.util.*;

class SolveSudoku {

    public static boolean isValid(char[][] board, int i, int j, char possibleValue) {
        for (int k = 0; k < 9; k++) {
            if (board[k][j] == possibleValue) {
                return false;
            }
        }

        for (int k = 0; k < 9; k++) {
            if (board[i][k] == possibleValue) {
                return false;
            }
        }

        int sti = (i/3)*3;
        int stj = (j/3)*3;
        for (int k = sti; k < sti + 3; k++) {
            for (int l = stj; l < stj + 3; l++) {
                if (board[k][l] == possibleValue) {
                    return false;
                }
            }
        }

        return true;
    }

    static char[] chars = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static char[][] solveSudoku(char[][] board) {

        solveSudokuRecur(board, 0, 0);

        return board;
    }

    private static boolean solveSudokuRecur(char[][] board, int i, int j) {

        System.out.println("i = " + i + ", j = " + j);
        //System.out.println("board = " + Arrays.deepToString(board) + ", i = " + i + ", j = " + j);

        if (j >= 9) {
            i = i + 1;
            j = 0;
        }

        if (i >= 9) {
            return true;
        }

        if (board[i][j] == '.') {
            for (int k = 0; k < chars.length; k++) {
                if (isValid(board, i, j, chars[k])) {
                    // System.out.println("chars[k] : " + chars[k]);
                    board[i][j] = chars[k];
                    boolean res = solveSudokuRecur(board, i, j+1);
                    if (res) {
                        return true;
                    } else {
                        board[i][j] = '.';
                    }
                }
            }
            return false;
        } else {
            return solveSudokuRecur(board, i, j+1);
        }
    }

}