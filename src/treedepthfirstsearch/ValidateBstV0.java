package treedepthfirstsearch;

import utils.TreeNode;

public class ValidateBstV0 {

    public static TreeNode<Integer> inOrderPredecessor(TreeNode<Integer> root) {
        if (root.left == null) {
            return null;
        }
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public static TreeNode<Integer> inOrderSuccessor(TreeNode<Integer> root) {
        if (root.right == null) {
            return null;
        }
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static boolean validateBst(TreeNode<Integer> root) {

        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        TreeNode<Integer> inOrderPredecessor = inOrderPredecessor(root);
        TreeNode<Integer> inOrderSuccessor = inOrderSuccessor(root);

        if ((inOrderPredecessor == null || inOrderPredecessor.data <= root.data) &&
                (inOrderSuccessor == null || root.data <= inOrderSuccessor.data)) {
            boolean l = validateBst(root.left);
            boolean r = validateBst(root.right);

            return l && r;
        }

        return false;
    }

}
