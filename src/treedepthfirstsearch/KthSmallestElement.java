package treedepthfirstsearch;

import utils.*;

public class KthSmallestElement {

    public static int kthSmallestElement(TreeNode<Integer> root, int k) {
        int[] cnt = {0};
        return recur(root, k, cnt).data;
    }

    public static TreeNode<Integer> recur(TreeNode<Integer> root, int k, int[] cnt) {
        if (root == null) {
            return null;
        }
        TreeNode<Integer> l = recur(root.left, k, cnt);
        if (l != null) {
            return l;
        }
        cnt[0] ++;
        if (cnt[0] == k) {
            return root;
        }
        TreeNode<Integer> r = recur(root.right, k, cnt);
        return r;
    }


}
