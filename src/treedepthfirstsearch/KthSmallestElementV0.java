package treedepthfirstsearch;

import utils.TreeNode;

public class KthSmallestElementV0 {

    public static int cnt = 0;

    public static int kthSmallestElement(TreeNode<Integer> root, int k) {
        cnt = 0;
        return recur(root, k).data;
    }

    public static TreeNode<Integer> recur(TreeNode<Integer> root, int k) {
        if (root == null) {
            return null;
        }
        TreeNode<Integer> l = recur(root.left, k);
        if (l != null) {
            return l;
        }
        cnt ++;
        if (cnt == k) {
            return root;
        }
        TreeNode<Integer> r = recur(root.right, k);
        return r;
    }


}
