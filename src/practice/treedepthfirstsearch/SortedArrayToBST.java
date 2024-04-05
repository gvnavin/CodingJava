package practice.treedepthfirstsearch;

import practice.utils.TreeNode;

public class SortedArrayToBST {

    public static TreeNode<Integer> sortedArrayToBST(int[] nums) {
        return recurHelper(nums, 0, nums.length - 1);
    }

    private static TreeNode<Integer> recurHelper(int[] nums, int s, int e) {

        System.out.println("s = " + s + " e = " + e);

        if (s > e) {
            return null;
        }

        if (s == e) {
            return new TreeNode<>(nums[s]);
        }

        int mid = s + (e - s) / 2;

        TreeNode<Integer> node = new TreeNode<>(nums[mid]);

        TreeNode<Integer> l = recurHelper(nums, s, mid - 1);
        TreeNode<Integer> r = recurHelper(nums, mid + 1, e);

        node.left = l;
        node.right = r;

        return node;
    }

}
