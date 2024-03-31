package treedepthfirstsearch;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {

    public static List<Integer> rightSideView(TreeNode<Integer> root) {

        ArrayList<Integer> rightSideView = new ArrayList<>();
        recur(root, rightSideView, 0);

        return rightSideView;
    }

    public static void recur(TreeNode<Integer> root, List<Integer> rightSideView, int level) {

        if (root == null) {
            return;
        }

        if (rightSideView.size() <= level) {
            rightSideView.add(root.data);
        } else {
            rightSideView.set(level, root.data);
        }

        recur(root.left, rightSideView, level+1);
        recur(root.right, rightSideView, level+1);

    }

}
