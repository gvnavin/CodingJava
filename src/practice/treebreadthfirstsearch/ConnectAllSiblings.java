package practice.treebreadthfirstsearch;

import practice.utils.EduTreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class ConnectAllSiblings {

    public static EduTreeNode<Integer> connectAllSiblings(EduTreeNode<Integer> root) {

        Queue<EduTreeNode<Integer>> q = new ArrayDeque<>();

        q.add(root);

        EduTreeNode<Integer> previous = null;

        while(!q.isEmpty()) {
            EduTreeNode<Integer> node = q.poll();
            if (previous == null) {
                previous = node;
            } else {
                previous.next = node;
                previous = node;
            }

            if (node.left != null) {
                q.add(node.left);
            }

            if (node.right != null) {
                q.add(node.right);
            }
        }

        return root;
    }

}
