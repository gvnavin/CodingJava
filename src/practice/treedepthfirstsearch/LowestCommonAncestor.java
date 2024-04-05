package practice.treedepthfirstsearch;

import practice.utils.TreeNode;

public class LowestCommonAncestor {
    public TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {

        return recur(root, p, q).node;
    }

    static class Node {
        int fountCnt;
        TreeNode<Integer> node;

        public Node() {
        }

        @Override
        public String toString() {
            return "Node{" +
                    "fountCnt=" + fountCnt +
                    ", node=" + node +
                    '}';
        }
    }

    private Node recur(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if (root == null) {
            return new Node();
        }

        Node node = new Node();
        if (root.data == p.data) {
            node.fountCnt ++;
        }

        if (root.data == q.data) {
            node.fountCnt ++;
        }

        Node l = recur(root.left, p, q);
        Node r = recur(root.right, p, q);
        node.fountCnt += l.fountCnt;
        node.fountCnt += r.fountCnt;

        if (node.fountCnt >= 2) {
            if (l.node != null) {
                node.node = l.node;
            } else if (r.node != null) {
                node.node = r.node;
            } else {
                node.node = root;
            }
        }

        return node;
    }
}
