package treedepthfirstsearch;

import utils.TreeNode;

public class DiameterOfTheTree {

    static class Node {
        int height, diameter;

        public Node(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static Node recur(TreeNode<Integer> root) {

        if (root.left == null && root.right == null) {
            return new Node(1, 0);
        }

        Node l = recur(root.left);
        Node r = recur(root.right);

        int h = Math.max(l.height, r.height) + 1;
        int diameterOfChildren = Math.max(l.diameter, r.diameter);
        int d = Math.max(diameterOfChildren, l.height + r.height);

        return new Node(h, d);
    }

    public static int diameterOfBinaryTree(TreeNode<Integer> root) {
        return recur(root).diameter;
    }
}
