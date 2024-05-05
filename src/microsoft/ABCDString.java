package microsoft;

import com.sun.source.tree.BreakTree;

import java.util.HashMap;
import java.util.Stack;

public class ABCDString {

    public String solution(String inp) {
        HashMap<Character, Character> charMap = new HashMap<>();

        charMap.put('A', 'B');
        charMap.put('B', 'A');
        charMap.put('C', 'D');
        charMap.put('D', 'C');

        Stack<Character> stk = new Stack<>();
        for (char c : inp.toCharArray()) {
            Character tc = charMap.get(c);
            if (!stk.isEmpty() && stk.peek() == tc) {
                stk.pop();
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

    public static void main(String[] args) {
        ABCDString abcdString = new ABCDString();
        String ret = abcdString.solution("BABABAAAABCB");
        System.out.println("ret = " + ret);
    }
}
