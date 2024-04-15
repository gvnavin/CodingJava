package practice.stack;

import java.util.Stack;

public class RemoveDuplicates {
    public static String removeDuplicates(String s) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (stk.isEmpty()) {
                stk.push(c);
            } else if (stk.peek() != c) {
                stk.push(c);
            } else {
                stk.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }

        return sb.reverse().toString();
    }
}
