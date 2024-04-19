package practice.subsets;

import java.util.*;

public class PhoneLetterCombinations {

    HashMap<Character, String> digitToStringMap = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        digitToStringMap.put('2', "abc");
        digitToStringMap.put('3', "def");
        digitToStringMap.put('4', "ghi");
        digitToStringMap.put('5', "jkl");
        digitToStringMap.put('6', "mno");
        digitToStringMap.put('7', "pqrs");
        digitToStringMap.put('8', "tuv");
        digitToStringMap.put('9', "wxyz");

        ArrayList<String> ret = new ArrayList<>();
        recur(digits, "", ret);

        return ret;
    }

    private void recur(String digits, String inp, ArrayList<String> ret) {

        if (digits.isBlank()) {
            ret.add(inp);
            return;
        }

        char key = digits.charAt(0);
        System.out.println("key = " + key);
        String chars = digitToStringMap.get(key);
        System.out.println("chars = " + chars);
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            String newInp = new String(inp);
            newInp = newInp + c;
            System.out.println("newInp = " + newInp);
            recur(digits.substring(1), newInp, ret);
        }
    }

}
