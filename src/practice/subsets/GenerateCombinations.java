package practice.subsets;

import java.util.*;
public class GenerateCombinations {
    public static ArrayList<String> generateCombinations(int n) {
        ArrayList<String> result = new ArrayList<String>();
        recur(n, "", 0, 0, result);
        return result;
    }
    private static void recur(int n, String inp, int open, int close, ArrayList<String> ret) {
        if (open + close == 2 * n) {
            ret.add(inp);
            return;
        }
        if (open < n) {
            recur(n, inp + "(", open+1, close, ret);
        }
        if (close < open && close < n) {
            recur(n, inp + ")", open, close+1, ret);
        }
    }
}
