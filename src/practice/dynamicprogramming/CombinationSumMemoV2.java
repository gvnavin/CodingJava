package practice.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

//not working
public class CombinationSumMemoV2 {

    static class Node {
        List<List<Integer>> val;

        public Node(List<List<Integer>> val) {
            this.val = val;
        }

        public Node() {
            this.val = new ArrayList<List<Integer>>();
        }

        public static Node valueOf() {
            return new Node();
        }

        public static Node valueOf(List<List<Integer>> val) {
            return new Node(val);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {

        ArrayList<List<Integer>> ret = new ArrayList<>();
        ArrayList<Integer> vals = new ArrayList<>();

        Node[][] memo = new Node[nums.length][target + 1];

        Node node = recur(nums, target, 0, 0, vals, ret, memo);

        return node.val;
    }

    public static Node recur(int[] nums, int target, int i, int sum, List<Integer> vals, List<List<Integer>> ret, Node[][] memo) {

        // System.out.println("i = " + i + " sum = " + sum);

        if (sum > target) {
            return Node.valueOf();
        }

        if (sum == target) {

            if(!ret.contains(vals)) {
                ret.add(vals);
            }

            return Node.valueOf(ret);
        }

        if (i >= nums.length) {
            return Node.valueOf();
        }

        if (i == 1 && sum == 4) {
            System.out.println("i = " + i + " sum = " + sum + " memo[i][sum] " + memo[i][sum]);
        }

        // if (memo[i][sum] != null) {
        //     return memo[i][sum];
        // }

        ArrayList<Integer> vals1 = new ArrayList<>(vals);
        vals1.add(nums[i]);

        ArrayList<Integer> vals2 = new ArrayList<>(vals);
        vals2.add(nums[i]);

        ArrayList<Integer> vals3 = new ArrayList<>(vals);

        Node ret1 = recur(nums, target, i + 1, sum + nums[i], vals1, ret, memo);
        Node ret2 = recur(nums, target, i, sum + nums[i], vals2, ret, memo);
        Node ret3 = recur(nums, target, i + 1, sum, vals3, ret, memo);

        // System.out.println("ret1 = " + ret1.val);
        // System.out.println("ret2 = " + ret2.val);
        // System.out.println("ret3 = " + ret3.val);

        for (List<Integer> integers : ret2.val) {
            if (!integers.isEmpty()) {
                ret1.val.add(integers);
            }
        }

        for (List<Integer> integers : ret3.val) {
            if (!integers.isEmpty()) {
                ret1.val.add(integers);
            }
        }

        memo[i][sum] = ret1;
        return memo[i][sum];

    }

}
