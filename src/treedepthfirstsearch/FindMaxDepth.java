package treedepthfirstsearch;

import utils.*;

public class FindMaxDepth {

    public static int findMaxDepth(TreeNode<Integer> root) {
        return recur(root, 0);
    }

    public static int recur(TreeNode<Integer> root, int level) {
        if (root == null) {
            return level;
        }

        int l = recur(root.left, level+1);
        int r = recur(root.right, level+1);

        return Math.max(l, r);
    }

}
