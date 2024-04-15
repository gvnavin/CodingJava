package practice.stack;

import java.util.HashSet;
import java.util.Stack;

public class MinRemoveParentheses {

    static class Node {
        char c;
        int index;

        public Node(char c, int index) {
            this.c = c;
            this.index = index;
        }
    }

    public static String minRemoveParentheses(String s) {

        Stack<Node> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stk.push(new Node(c, i));
            } else if (c == ')') {
                if (!stk.isEmpty() && stk.peek().c == '(') {
                    stk.pop();
                } else {
                    stk.push(new Node(c, i));
                }
            }
        }

        HashSet<Integer> indexes = new HashSet<>();

        while (!stk.isEmpty()) {
            indexes.add(stk.pop().index);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexes.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
