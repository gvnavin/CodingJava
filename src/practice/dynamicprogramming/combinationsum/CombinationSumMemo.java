package practice.dynamicprogramming.combinationsum;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumMemo {

    public static List<List<Integer>> combinationSum(int[] nums, int target) {

        ArrayList<List<Integer>> ret = new ArrayList<>();
        ArrayList<Integer> vals = new ArrayList<>();

        @SuppressWarnings("unchecked")
        List<List<Integer>>[][] memo = (List<List<Integer>>[][]) new List[nums.length][target+1];

        List<List<Integer>> rets = recur(nums, target, 0, 0, vals, ret, memo);

        return rets;
    }

    public static List<List<Integer>> recur(int[] nums, int target, int i, int sum, List<Integer> vals, List<List<Integer>> ret, List<List<Integer>>[][] memo) {

        System.out.println("i = " + i + " sum = " + sum);

        if (sum > target) {
            return new ArrayList<>();
        }

        if (sum == target) {

            if(!ret.contains(vals)) {
                ret.add(vals);
            }

            return ret;
        }

        if (i >= nums.length) {
            return new ArrayList<>();
        }

        if (memo[i][sum] != null) {
            return memo[i][sum];
        }

        ArrayList<Integer> vals1 = new ArrayList<>(vals);
        vals1.add(nums[i]);

        ArrayList<Integer> vals2 = new ArrayList<>(vals);
        vals2.add(nums[i]);

        ArrayList<Integer> vals3 = new ArrayList<>(vals);

        List<List<Integer>> ret1 = recur(nums, target, i + 1, sum + nums[i], vals1, ret, memo);
        List<List<Integer>> ret2 = recur(nums, target, i, sum + nums[i], vals2, ret, memo);
        List<List<Integer>> ret3 = recur(nums, target, i + 1, sum, vals3, ret, memo);

        System.out.println("ret1 = " + ret1);
        System.out.println("ret2 = " + ret2);
        System.out.println("ret3 = " + ret3);

        for (List<Integer> integers : ret2) {
            if (!integers.isEmpty()) {
                ret1.add(integers);
            }
        }

        for (List<Integer> integers : ret3) {
            if (!integers.isEmpty()) {
                ret1.add(integers);
            }
        }

        memo[i][sum] = ret1;
        return memo[i][sum];

    }

}
