package practice.backtracking;

public class WordSearchV0 {

    public static boolean wordSearchRec(char[][] grid, String word, int i, int j, String newWord) {

        if (newWord.length() == word.length() && newWord.equalsIgnoreCase(word)) {
            return true;
        } else if (newWord.length() >= word.length()) {
            return false;
        } else if (i >= grid.length || (i < grid.length && j >= grid[i].length)) {
            return false;
        }

        if ( Character.toLowerCase(grid[i][j]) == Character.toLowerCase(word.charAt(newWord.length())) ) {

            newWord = newWord + grid[i][j];
            boolean search1 = wordSearchRec(grid, word, i, j + 1, newWord);
            if (search1) {
                return true;
            }
            boolean search2 = wordSearchRec(grid, word, i + 1, j, newWord);
            return search2;
        }

        return false;

    }

    public static boolean wordSearch(char[][] grid, String word) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (wordSearchRec(grid, word, i, j, "")) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String args[]) {
        char[][][] grids = {
                {{'E', 'D', 'X', 'I', 'W'},
                        {'P', 'U', 'F', 'M', 'Q'},
                        {'I', 'C', 'Q', 'R', 'F'},
                        {'M', 'A', 'L', 'C', 'A'},
                        {'J', 'T', 'I', 'V', 'E'}},

                {{'E', 'D', 'X', 'I', 'W'},
                        {'P', 'A', 'F', 'M', 'Q'},
                        {'I', 'C', 'A', 'S', 'F'},
                        {'M', 'A', 'L', 'C', 'A'},
                        {'J', 'T', 'I', 'V', 'E'}},

                {{'h', 'e', 'c', 'm', 'l'},
                        {'w', 'l', 'i', 'e', 'u'},
                        {'a', 'r', 'r', 's', 'n'},
                        {'s', 'i', 'i', 'o', 'r'}},

                {{'C', 'Q', 'N', 'A'},
                        {'P', 'S', 'E', 'I'},
                        {'Z', 'A', 'P', 'E'},
                        {'J', 'V', 'T', 'K'}},


                {{'O', 'Y', 'O', 'I'},
                        {'B', 'I', 'E', 'M'},
                        {'K', 'D', 'Y', 'R'},
                        {'M', 'T', 'W', 'I'},
                        {'Z', 'I', 'T', 'O'}}
        };
        String[] words = {"educative", "PACANS", "WARRIOR", "save", "DYNAMIC"};
        for (int i = 0; i < words.length; i++) {
            System.out.println((i + 1) + ".\tGrid = ");
            printGrid(grids[i]);
            System.out.println("\tWord = " + words[i]);
            System.out.println("\n\tProcessing...");
            Boolean result = wordSearch(grids[i], words[i]);
            if (result == true) {
                System.out.println("\n\tSearch result = Found Word");
            } else {
                System.out.println("\n\tSearch result = Word could not be found");
            }

            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    public static void printGrid(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            System.out.print("\t\t[");
            for (int j = 0; j < grid[0].length; j++) {
                if (j < grid[0].length - 1)
                    System.out.print("'" + grid[i][j] + "', ");
                else
                    System.out.print("'" + grid[i][j] + "'");
            }
            System.out.println("]");
        }
        System.out.println("\n");
    }


}
