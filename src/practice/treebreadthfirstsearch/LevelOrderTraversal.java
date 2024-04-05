package practice.treebreadthfirstsearch;

import practice.utils.TreeNode;

import java.util.ArrayList;

public class LevelOrderTraversal {

    public static String levelOrderTraversal(TreeNode<Integer> root) {

        if (root == null)  {
            return "None";
        }

        ArrayList<String> l = new ArrayList<>();
        recur(root, 0, l);

        return String.join(":", l);

    }

    public static void recur(TreeNode<Integer> root, int level, ArrayList<String> list) {

        if (root == null) {
            return;
        }

        if (list.size() <= level) {
            list.add(root.data.toString());
        } else {
            list.set(level, list.get(level) + "," + root.data);
        }

        recur(root.left, level + 1, list);
        recur(root.right, level + 1, list);

    }

}
