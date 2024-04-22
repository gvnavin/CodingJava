package practice.hashmap_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LongestPalindrome {
    public static int longestPalindrome(String s) {

        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            characterIntegerHashMap.merge(c, 1, (val1, val2) -> val1 + 1);
        }

        int sum = 0;
        boolean isOddPresent = false;
        Set<Map.Entry<Character, Integer>> entries = characterIntegerHashMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            if (entry.getValue() % 2 == 0) {
                sum += entry.getValue();
            } else {
                isOddPresent = true;
                sum += entry.getValue() - 1;
            }
        }

        if (isOddPresent) {
            sum ++;
        }

        return sum;
    }
}
