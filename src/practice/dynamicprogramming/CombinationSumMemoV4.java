package practice.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class CombinationSumMemoV4 {

    public static String createKey(int i, List<Integer> vals) {
        StringBuffer sb = new StringBuffer();
        sb.append(i);
        sb.append("#");
        for (Integer val : vals) {
            sb.append(val);
            sb.append("|");
        }

        return sb.toString();
    }

    public static boolean equals(List<Integer> val1, List<Integer> val2) {
        if (val1.size() != val2.size()) {
            return false;
        }

        for (int i = 0; i < val1.size(); i++) {
            if (val1.get(i) != val2.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean contains(List<List<Integer>> ret, List<Integer> vals) {
        for (List<Integer> integers : ret) {
            if(equals(integers, vals)) {
                return true;
            }
        }

        return false;
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {

        ArrayList<List<Integer>> ret = new ArrayList<>();
        ArrayList<Integer> vals = new ArrayList<>();

        HashMap<String, List<List<Integer>>> memo = new HashMap<>();

        List<List<Integer>> ret2 = recur(nums, target, 0, 0, vals, ret, memo);

        return ret2;
    }

    public static List<List<Integer>> recur(int[] nums, int target, int i, int sum, List<Integer> vals, List<List<Integer>> ret, HashMap<String, List<List<Integer>>> memo) {

        // System.out.println("i = " + i + " sum = " + sum);

        if (sum > target) {
            return ret;
        }

        if (sum == target) {
            if(!ret.contains(vals)) {
                ret.add(vals);
            }

            return ret;
        }

        if (i >= nums.length) {
            return ret;
        }


        String key = createKey(i, vals);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        ArrayList<Integer> vals1 = new ArrayList<>(vals);
        vals1.add(nums[i]);

        ArrayList<Integer> vals2 = new ArrayList<>(vals);
        vals2.add(nums[i]);

        ArrayList<Integer> vals3 = new ArrayList<>(vals);

        List<List<Integer>> ret1 = recur(nums, target, i + 1, sum + nums[i], vals1, ret, memo);
        List<List<Integer>> ret2 = recur(nums, target, i, sum + nums[i], vals2, ret, memo);
        List<List<Integer>> ret3 = recur(nums, target, i + 1, sum, vals3, ret, memo);

        // System.out.println("ret1 = " + ret1.val);
        // System.out.println("ret2 = " + ret2.val);
        // System.out.println("ret3 = " + ret3.val);

        List<List<Integer>> newRet = new ArrayList<>();

        for (List<Integer> integers : ret1) {
            if (!integers.isEmpty()) {
                if(!newRet.contains(integers)) {
                    newRet.add(integers);
                }
            }
        }

        for (List<Integer> integers : ret2) {
            if (!integers.isEmpty()) {
                if(!newRet.contains(integers)) {
                    newRet.add(integers);
                }
            }
        }

        for (List<Integer> integers : ret3) {
            if (!integers.isEmpty()) {
                if(!newRet.contains(integers)) {
                    newRet.add(integers);
                }
            }
        }

        memo.put(key, newRet);

        return newRet;

    }

}
