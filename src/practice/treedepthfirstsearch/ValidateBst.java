package practice.treedepthfirstsearch;

import practice.utils.TreeNode;

public class ValidateBst {

    static int inOrderPredecessor = Integer.MIN_VALUE;
    public static boolean validateBst(TreeNode<Integer> root) {
        inOrderPredecessor = Integer.MIN_VALUE;
        return recur(root);
    }

    private static boolean recur(TreeNode<Integer> root) {
        if (root == null) {
            return true;
        }

        if(!recur(root.left)) {
            return false;
        }

        if (inOrderPredecessor > root.data) {
            return false;
        }

        inOrderPredecessor = root.data;

        return recur(root.right);
    }

}
