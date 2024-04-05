package practice.treebreadthfirstsearch;

import practice.utils.TreeNode;

import java.util.*;

public class VerticalOrderV0 {

    public static List<List<Integer>> verticalOrder(TreeNode<Integer> root) {

        HashMap<Integer, List<Integer>> levelToVerticalNodes = new HashMap<>();
        recur(root, 0, levelToVerticalNodes);

        Set<Integer> integers = levelToVerticalNodes.keySet();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Integer integer : integers) {
            min = Math.min(min, integer);
            max = Math.max(max, integer);
        }
        ArrayList<List<Integer>> ret = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            ret.add(levelToVerticalNodes.get(i));
        }

        return ret;
    }

    public static void recur(TreeNode<Integer> root, int level, HashMap<Integer, List<Integer>> levelToVerticalNodes) {
        if (root == null) {
            return;
        }

        List<Integer> verticalNodes = levelToVerticalNodes.getOrDefault(level, new ArrayList<>());
        verticalNodes.add(root.data);
        levelToVerticalNodes.put(level, verticalNodes);

        recur(root.left, level-1, levelToVerticalNodes);
        recur(root.right, level+1, levelToVerticalNodes);

    }

}
