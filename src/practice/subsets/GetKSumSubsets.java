package practice.subsets;
import java.util.*;

public class GetKSumSubsets {
    public static List<List<Integer>> getKSumSubsets(List<Integer> setOfIntegers, int targetSum) {

        List<List<Integer>> ret = new ArrayList<>();
        recur(setOfIntegers, 0, targetSum, 0, new ArrayList<Integer>(), ret);
        return ret;
    }

    public static void recur(List<Integer> setOfIntegers, int i, int target, int sum, ArrayList<Integer> inp, List<List<Integer>> ret) {
        if (sum == target) {
            ret.add(inp);
            return;
        }

        if (sum > target || i >= setOfIntegers.size()) {
            return;
        }

        Integer val = setOfIntegers.get(i);
        ArrayList<Integer> newInp1 = new ArrayList<>(inp);
        ArrayList<Integer> newInp2 = new ArrayList<>(inp);

        newInp1.add(val);

        recur(setOfIntegers, i+1, target, sum + val, newInp1, ret);
        recur(setOfIntegers, i+1, target, sum, newInp2, ret);
    }
}
