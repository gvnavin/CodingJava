package practice.stack;

import java.util.Stack;

public class ValidParenthesisV0 {

    public static boolean isValid(String s) {

        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (stk.isEmpty() && (c == '[' || c == '(' || c == '{') ) {
                stk.push(c);
                continue;
            }

            if (c == '[' || c == '(' || c == '{') {
                stk.push(c);
            } else {
                if (!stk.isEmpty() && stk.peek() == '[' && c == ']') {
                    stk.pop();
                } else if (!stk.isEmpty() && stk.peek() == '(' && c == ')') {
                    stk.pop();
                } else if (!stk.isEmpty() && stk.peek() == '{' && c == '}') {
                    stk.pop();
                } else {
                    return false;
                }
            }

        }

        if (stk.empty()) {
            return true;
        }

        return false;
    }
}
