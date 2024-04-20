package practice.slidingwindow_dynamic;

public class MinimumWindowSubsequence {

    public static String minWindow(String s, String t) {

        int[] charCount = new int[26];
        for (char c : t.toCharArray()) {
            charCount[c - 'a']++;
        }

        int beg = 0;
        int end = 0;
        int[] charCountFoundSoFar = new int[26];

        int minLen = Integer.MAX_VALUE;
        int minInd = -1;

        while (end < s.length()) {
            char endKey = s.charAt(end);
            charCountFoundSoFar[endKey - 'a']++;
            while (match(charCount, charCountFoundSoFar)) {
                int newLen = end - beg + 1;
                if (newLen < minLen) {
                    minLen = newLen;
                    minInd = beg;
                }
                char begKey = s.charAt(beg);
                charCountFoundSoFar[begKey - 'a']--;
                beg++;
            }
            end++;
        }

        if (minInd != -1) {
            return s.substring(minInd, minInd + minLen);
        } else {
            return "";
        }

    }

    private static boolean match(int[] charCount, int[] charCountFoundSoFar) {

        for (int i = 0; i < 26; i++) {
            if (charCountFoundSoFar[i] < charCount[i]) {
                return false;
            }
        }

        return true;
    }

    // Driver code
    public static void main(String[] args) {
        // Driver code
        String[] str1 = {
//                "abcdbebe",
//                "abcdebdde",
//                "abcdedeaqdweq",
                "fgrqsqsnodwmxzkzxwqegkndaa",
//                "zxcvnhss",
//                "alpha",
//                "beta"
        };
        String[] str2 = {
//                "bbe",
//                "bde",
//                "adeq",
                "kzed",
//                "css",
//                "la",
//                "ab"
        };
        for (int i = 0; i < str1.length; i++) {
            System.out.println(i + 1 + ".\tInput String: " + "(" + str1[i] + ", " + str2[i] + ")");
            System.out.println("\tSubsequence string: " + minWindow(str1[i], str2[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
