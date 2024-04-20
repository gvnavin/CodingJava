package practice.slidingwindow_dynamic;

import java.util.Arrays;

public class FindLongestSubstringWithoutRepeatingCharacter {

    public static int findLongestSubstring(String str) {

        str = str.toLowerCase();

        int[] charCount = new int[26];

        int beg = 0;
        int end = 0;
        int maxLen = Integer.MIN_VALUE;

        while(beg <= end && end < str.length()) {
            char endKey = str.charAt(end);
            if (charCount[endKey - 'a'] == 0) {
                charCount[endKey - 'a']++;
                if (noRepeat(charCount, beg, end, str)) {
                    maxLen = Math.max(maxLen, end - beg + 1);
                }
                end++;
            } else {
                char begKey = str.charAt(beg);
                charCount[begKey - 'a']--;
                beg++;
            }
        }

        return maxLen;
    }

    private static boolean noRepeat(int[] charCount, int beg, int end, String str) {
        System.out.println("charCount = " + Arrays.toString(charCount) + ", beg = " + beg + ", end = " + end + ", str = " + str);
        String subString = str.substring(beg, end+1);
        for (char ch : subString.toCharArray()) {
            int cnt = charCount[ch - 'a'];
            if (cnt != 1) {
                return false;
            }
        }
        return true;
    }
}
