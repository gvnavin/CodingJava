package treebreadthfirstsearch;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//2 stack
public class ZigzagLevelOrder {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode<Integer> root) {

        Deque<TreeNode<Integer>> dq = new ArrayDeque<>();
        if (root != null) {
            dq.add(root);
        }

        boolean reverse = false;
        List<List<Integer>> ll = new ArrayList<>();

        while(!dq.isEmpty()) {

            int size = dq.size();
            List<Integer> l = new ArrayList<>();

            if (reverse) {
                for (int i = 0; i < size; i++) {
                    TreeNode<Integer> node = dq.pollLast();
                    l.add(node.data);
                    if (node.right != null) {
                        dq.addFirst(node.right);
                    }
                    if (node.left != null) {
                        dq.addFirst(node.left);
                    }
                }

            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode<Integer> node = dq.pollFirst();
                    l.add(node.data);
                    if (node.left != null) {
                        dq.add(node.left);
                    }
                    if (node.right != null) {
                        dq.add(node.right);
                    }
                }
            }

            ll.add(l);
            reverse = !reverse;

        }

        return ll;
    }

}
