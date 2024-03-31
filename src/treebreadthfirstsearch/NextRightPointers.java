package treebreadthfirstsearch;

import utils.EduTreeNode;

public class NextRightPointers {

    public static EduTreeNode<Integer> populateNextPointers(EduTreeNode<Integer> root) {

        recur(root);

        return root;
    }

    private static void recur(EduTreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        if (root.left != null && root.right != null) {
            root.left.next = root.right;
        }

        EduTreeNode<Integer> left = null;

        if (root.right != null) {
            left = root.right;
        } else if (root.left != null) {
            left = root.right;
        }

        EduTreeNode<Integer> right = null;

        if (root.next != null && root.next.left != null) {
            right = root.next.left;
        } else if (root.next != null && root.next.right != null) {
            right = root.next.right;
        }

        if (left != null && right != null) {
            left.next = right;
        }

        populateNextPointers(root.left);
        populateNextPointers(root.right);


    }

}
