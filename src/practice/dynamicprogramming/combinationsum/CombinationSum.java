package practice.dynamicprogramming.combinationsum;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] nums, int target) {

        ArrayList<List<Integer>> ret = new ArrayList<>();
        ArrayList<Integer> vals = new ArrayList<>();

        recur(nums, target, 0, 0, vals, ret);

        return ret;
    }

    public static void recur(int[] nums, int target, int i, int sum, List<Integer> vals, List<List<Integer>> ret) {

        if (sum > target) {
            return;
        }

        if (sum == target) {
            if(!ret.contains(vals)) {
                ret.add(vals);
            }
        }

        if (i >= nums.length) {
            return;
        }

        ArrayList<Integer> vals1 = new ArrayList<>(vals);
        vals1.add(nums[i]);

        ArrayList<Integer> vals2 = new ArrayList<>(vals);
        vals2.add(nums[i]);

        ArrayList<Integer> vals3 = new ArrayList<>(vals);

        recur(nums, target, i + 1, sum + nums[i], vals1, ret);
        recur(nums, target, i, sum + nums[i], vals2, ret);
        recur(nums, target, i + 1, sum, vals3, ret);

    }
}
