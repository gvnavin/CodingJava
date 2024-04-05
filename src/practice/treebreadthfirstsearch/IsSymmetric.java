package practice.treebreadthfirstsearch;

import practice.utils.TreeNode;

public class IsSymmetric {

    public static boolean isSymmetric(TreeNode<Integer> root) {
        return recur(root.left, root.right);
    }

    public static boolean recur(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        } else if (root1 != null && root2 != null && root1.data != root2.data) {
            return false;
        }

        boolean l = recur(root1.left, root2.right);
        boolean r = recur(root1.right, root2.left);

        return l && r;
    }


}
