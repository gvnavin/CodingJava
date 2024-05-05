package microsoft;


// you can also use imports, for example:

import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class ABCDStringV0 {
    public String solution(String inp) {
        Stack<Character> stk = new Stack<>();
        for (char c : inp.toCharArray()) {
            if (stk.isEmpty()) {
                stk.push(c);
            } else if (c == 'A') {
                if (!stk.isEmpty() && stk.peek() == 'B') {
                    stk.pop();
                } else {
                    stk.push(c);
                }
            } else if (c == 'B') {
                if (!stk.isEmpty() && stk.peek() == 'A') {
                    stk.pop();
                } else {
                    stk.push(c);
                }
            } else if (c == 'C') {
                if (!stk.isEmpty() && stk.peek() == 'D') {
                    stk.pop();
                } else {
                    stk.push(c);
                }
            } else if (c == 'D') {
                if (!stk.isEmpty() && stk.peek() == 'C') {
                    stk.pop();
                } else {
                    stk.push(c);
                }
            } else {
                stk.push(c);
            }
        }
        String tmpStr = "";
        while (!stk.isEmpty()) {
            tmpStr = stk.pop() + tmpStr;
        }
        return tmpStr;
    }
}
