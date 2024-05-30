package uber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] inp = new String[]{"Water", "Uber", "Train", "Trip", "Universe"};
//        String[] inp = new String[]{"Train", "Trip"};
        new Main().solution(inp);
    }


    static class Node {
        char c;
        Map<Character, Node> children;
        int cnt = 0;

        public Node(char c) {
            this.c = c;
            children = new HashMap<>();
        }

        public void addChildren(Node node) {
            children.put(node.c, node);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "c=" + c +
                    ", children=" + children.keySet() +
                    '}';
        }
    }

    String[] solution(String[] list) {

        Node root = new Node('/');

        for (String inp : list) {
//            System.out.println("adding to Trie inp = " + inp);
            addToTrie(inp, 0, root);
//            System.out.println("root = " + root);
        }

        String[] ret = new String[list.length];
        int i = 0;
        for (String inp : list) {
            int[] arr = new int[1];
            System.out.println("traverse inp = " + inp);
            traverse(inp, 0, root, arr);
            int prefixIndex = arr[0];
            System.out.println("prefixIndex = " + prefixIndex);
            ret[i] = inp.substring(0, prefixIndex + 1);
            System.out.println("ret[i] = " + ret[i]);
            i++;
        }

        System.out.println("ret = " + Arrays.toString(ret));

        return ret;
    }

    private int traverse(String str, int i, Node root, int[] arr) {

        System.out.println("traverse str = " + str + ", i = " + i + ", root = " + root);

        if (i >= str.length()) {
            return i;
        }

        char c = str.charAt(i);
        System.out.println("c = " + c);
        if (root.c == '/') {
            traverse(str, i, root.children.get(c), arr);
        } else if (c == root.c) {
            System.out.println("} else if (c == root.c) {");
            if (root.cnt == 1) {
                System.out.println("i = " + i);
                arr[0] = i;
                return i;
            } else {
                if (i+1 < str.length()) {
                    Node childRoot = root.children.get(str.charAt(i+1));
                System.out.println("c = " + c);
                System.out.println("childRoot = " + childRoot);
                traverse(str, i + 1, childRoot, arr);
                }
            }
        }
        return i;
    }


    void addToTrie(String str, int i, Node root) {
        if (i >= str.length()) {
            return;
        }

        char c = str.charAt(i);
        root.cnt ++;
        if (root.children.containsKey(c)) {
            addToTrie(str, i + 1, root.children.get(c));
        } else {
            Node tempNode = new Node(c);
            root.addChildren(tempNode);
            addToTrie(str, i + 1, root.children.get(c));
        }
    }

}
