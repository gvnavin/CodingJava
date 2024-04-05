package practice.treedepthfirstsearch;

import practice.utils.TreeNode;

public class LowestCommonAncestorV0 {
    public TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {

        return recur(root, p, q).node;
    }

    static class Node {
        boolean pFound;
        boolean qFound;
        TreeNode<Integer> node;

        public Node(boolean pFound, boolean qFound, TreeNode<Integer> node) {
            this.pFound = pFound;
            this.qFound = qFound;
            this.node = node;
        }

        public Node(boolean pFound, boolean qFound) {
            this(pFound, qFound, null);
        }

        public Node() {
            this(false, false, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "pFound=" + pFound +
                    ", qFound=" + qFound +
                    ", node=" + node +
                    '}';
        }
    }

    private Node recur(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if (root == null) {
            return new Node();
        }

        boolean pFound = false;
        if (root.data == p.data) {
            pFound = true;
        }

        boolean qFound = false;
        if (root.data == q.data) {
            qFound = true;
        }

        Node l = recur(root.left, p, q);
        Node r = recur(root.right, p, q);

        pFound = pFound || l.pFound || r.pFound;
        qFound = qFound || l.qFound || r.qFound;

        if (pFound && qFound) {
            Node node = new Node(pFound, qFound);
            if (l.node != null) {
                node.node = l.node;
            } else if (r.node != null) {
                node.node = r.node;
            } else {
                node.node = root;
            }
            return node;
        }

        return new Node(pFound, qFound, null);
    }
}
