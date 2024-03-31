package treedepthfirstsearch;

import utils.TreeNode;

public class MaxPathSum {

    static class Node {
        int heightSum;
        int pathSum;

        public Node() {
        }

        public Node(int heightSum, int pathSum) {
            this.heightSum = heightSum;
            this.pathSum = pathSum;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "heightSum=" + heightSum +
                    ", pathSum=" + pathSum +
                    '}';
        }
    }
    public static int maxPathSum(TreeNode<Integer> root) {
        return recur(root).pathSum;
    }

    public static Node recur(TreeNode<Integer> root) {
        if (root == null) {
            return new Node();
        }

        if (root.left == null && root.right == null) {
            return new Node(root.data, root.data);
        }

        Node l = recur(root.left);
        Node r = recur(root.right);

        System.out.println("root.data = " + root.data);
        System.out.println("l = " + l);
        System.out.println("r = " + r);

        int heightSum = Math.max(Math.max(l.heightSum, r.heightSum), 0);
        heightSum = Math.max(Math.max(heightSum + root.data, root.data), 0);

        System.out.println("heightSum = " + heightSum);

        int pathsum = Math.max(l.pathSum, r.pathSum);
        pathsum = Math.max(l.heightSum + r.heightSum + root.data, pathsum);

        System.out.println("pathsum = " + pathsum);
        System.out.println("-------------------");

        return new Node(heightSum, pathsum);
    }

}
