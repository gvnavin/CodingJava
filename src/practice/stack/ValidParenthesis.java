package practice.stack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ValidParenthesis {

    public static boolean isValid(String s) {

        Set<Character> open = new HashSet<>();
        open.add('[');
        open.add('(');
        open.add('{');

        HashMap<Character, Character> mp = new HashMap<>();
        mp.put('[', ']');
        mp.put('(', ')');
        mp.put('{', '}');

        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (stk.isEmpty() && open.contains(c)) {
                stk.push(c);
            } else if (open.contains(c)) {
                stk.push(c);
            } else if (!stk.isEmpty() && mp.get(stk.peek()) == c) {
                stk.pop();
            } else {
                return false;
            }

        }

        if (stk.empty()) {
            return true;
        }

        return false;
    }
}
