package practice.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    static class CustomHashMap {
        Map<Character, Integer> characterToIndexMap = new HashMap<>();

        public void put(char c, int index) {
            characterToIndexMap.put(c, index);
        }

        public boolean isPresent(char c) {
            return characterToIndexMap.containsKey(c);
        }

        public int getIndex(char c) {
            return characterToIndexMap.getOrDefault(c, -1);
        }

        public void remove(char c) {
            characterToIndexMap.remove(c);
        }

        public int removeTillCharAndReturnNewBeg(int beg, char c, String str) {
            int index = this.getIndex(c);
            for (int i = beg; i < index; i++) {
                this.remove(str.charAt(i));
            }
            return index;
        }

        public int getSize() {
            return characterToIndexMap.size();
        }
    }

    public static int findLongestSubstring(String str) {

        int beg = 0;
        int end = 0;
        int maxLength = 0;

        CustomHashMap chm = new CustomHashMap();

        while (end < str.length()) {

            char c = str.charAt(end);
            System.out.println("beg = " + beg + ", end = " + end + ", c = " + c);

            if (chm.isPresent(c)) {
                if (chm.getSize() > maxLength) {
                    maxLength = chm.getSize();
                }
                beg = chm.removeTillCharAndReturnNewBeg(beg, c, str);
            }
            chm.put(c, end);
            end++;
        }

        if (chm.getSize() > maxLength) {
            maxLength = chm.getSize();
        }

        return maxLength;
    }

    // Driver code
    public static void main(String[] arg) {
        String[] inputs = {
                "abcabcbb",
                "pwwkew",
                "bbbbb",
                "ababababa",
                "",
                "ABCDEFGHI",
                "ABCDEDCBA",
                "AAAABBBBCCCCDDDD"
        };
        for (int i = 0; i < inputs.length; i++) {
            int str = findLongestSubstring(inputs[i]);
            System.out.print(i + 1);
            System.out.println("\tInput string: " + inputs[i]);
            System.out.println("\n\tLength of longest substring: " + str);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
