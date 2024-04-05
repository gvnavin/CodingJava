package practice.treedepthfirstsearch;

import practice.utils.TreeNode;

public class InvertBinaryTree {
    public static TreeNode<Integer> invertTree(TreeNode<Integer> root){

        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return root;
        }

        invertTree(root.left);
        invertTree(root.right);

        TreeNode<Integer> temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }
}
