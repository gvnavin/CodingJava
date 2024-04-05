package practice.backtracking;

import practice.utils.BinaryTree;
import practice.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HouseRobber3 {

    public static int rob(TreeNode<Integer> root) {
        Value value = heistRecur(root);
        return Math.max(value.includingRoot, value.excludingRoot);
    }

    public static class Value {
        int includingRoot;
        int excludingRoot;

        public Value(int includingRoot, int excludingRoot) {
            this.includingRoot = includingRoot;
            this.excludingRoot = excludingRoot;
        }
    }

    public static Value heistRecur(TreeNode<Integer> root) {
        if (root == null) {
            return new Value(0, 0);
        }

        if (root.left == null && root.right == null) {
            return new Value(root.data, 0);
        }

        Value leftSubTree = heistRecur(root.left);
        Value rightSubTree = heistRecur(root.right);
        return new Value(
                root.data + leftSubTree.excludingRoot + rightSubTree.excludingRoot,
                Math.max(leftSubTree.includingRoot, leftSubTree.excludingRoot) + Math.max(rightSubTree.includingRoot, rightSubTree.excludingRoot)
        );
    }

    public static void main(String[] args) {
        List<List<TreeNode<Integer>>> listOfTrees = Arrays.asList(
                Arrays.asList(new TreeNode<Integer>(10), new TreeNode<Integer>(9), new TreeNode<Integer>(20), new TreeNode<Integer>(15), new TreeNode<Integer>(7)),
                Arrays.asList(new TreeNode<Integer>(7), new TreeNode<Integer>(9), new TreeNode<Integer>(10), new TreeNode<Integer>(15), new TreeNode<Integer>(20)),
                Arrays.asList(new TreeNode<Integer>(8), new TreeNode<Integer>(2), new TreeNode<Integer>(17), new TreeNode<Integer>(1), new TreeNode<Integer>(4),
                        new TreeNode<Integer>(19), new TreeNode<Integer>(5)),
                Arrays.asList(new TreeNode<Integer>(7), new TreeNode<Integer>(3), new TreeNode<Integer>(4), new TreeNode<Integer>(1), new TreeNode<Integer>(3)),
                Arrays.asList(new TreeNode<Integer>(9), new TreeNode<Integer>(5), new TreeNode<Integer>(7), new TreeNode<Integer>(1), new TreeNode<Integer>(3)),
                Arrays.asList(new TreeNode<Integer>(9), new TreeNode<Integer>(7), null, null, new TreeNode<Integer>(1), new TreeNode<Integer>(8), new TreeNode<Integer>(10), null, new TreeNode<Integer>(12))
        );

        List<BinaryTree<Integer>> inputTrees = new ArrayList<>();
        for (List<TreeNode<Integer>> ListOfNodes : listOfTrees) {
            BinaryTree<Integer> tree = new BinaryTree<>(ListOfNodes);
            inputTrees.add(tree);
        }

        int x = 1;
        for (BinaryTree<Integer> tree : inputTrees) {
            System.out.println(x + ".\tInput Tree:");
//            Print.displayTree(tree.root);
            x++;
            System.out.println("\n\tMaximum amount we can rob without getting caught: " + rob(tree.root));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
