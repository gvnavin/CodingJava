package practice.treebreadthfirstsearch;

import practice.utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class VerticalOrder {

    public static List<List<Integer>> verticalOrder(TreeNode<Integer> root) {

        HashMap<Integer, List<Integer>> levelToVerticalNodes = new HashMap<>();
        recur(root, 0, levelToVerticalNodes);

        ArrayList<Integer> arrayList = new ArrayList<>(levelToVerticalNodes.keySet());
        Collections.sort(arrayList);

        ArrayList<List<Integer>> ret = new ArrayList<>();
        for (Integer integer : arrayList) {
            ret.add(levelToVerticalNodes.get(integer));
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
