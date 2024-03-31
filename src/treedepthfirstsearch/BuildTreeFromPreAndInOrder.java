package treedepthfirstsearch;

import utils.TreeNode;

import java.util.HashMap;

public class BuildTreeFromPreAndInOrder {
    public static TreeNode<Integer> buildTree(int[] pOrder, int[] iOrder) {

        HashMap<Integer, Integer> iOrderToIndexMap = new HashMap<>();
        for (int i = 0; i < iOrder.length; i++) {
            iOrderToIndexMap.put(iOrder[i], i);
        }

        pi = 0;
        return recur(pOrder, iOrder, 0, pOrder.length-1, iOrderToIndexMap);
    }

    static int pi = 0;

    public static TreeNode<Integer> recur(int[] pOrder, int[] iOrder, int s, int e, HashMap<Integer, Integer> iOrderToIndexMap) {

        System.out.println("s = " + s + " e = " + e +" pi = " + pi);

        if (s > e) {
            return null;
        }

        int val = pOrder[pi];
        TreeNode<Integer> root = new TreeNode<>(val);
        pi ++;

        if (s == e) {
            return root;
        }

        Integer iInd = iOrderToIndexMap.get(val);

        TreeNode<Integer> l = recur(pOrder, iOrder, s, iInd-1, iOrderToIndexMap);
        TreeNode<Integer> r = recur(pOrder, iOrder, iInd+1, e, iOrderToIndexMap);

        root.left = l;
        root.right = r;

        return root;

    }

}
