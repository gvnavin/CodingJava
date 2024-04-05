package practice.slidingwindow;

public class MinSubsequence {

    static class ReturnHolder {
        String str;
        int index;

        public ReturnHolder(String str, int index) {
            this.str = str;
            this.index = index;
        }
    }

    public static String minWindow(String s, String t) {

        int si = 0;
        int minLength = Integer.MAX_VALUE;
        String minWindow = "";

        while (si < s.length()) {
            ReturnHolder returnHolder = findWindow(s, t, si);
            if (returnHolder == null) {
                break;
            }
            int localLength = returnHolder.str.length();
            if (localLength < minLength) {
                minLength = localLength;
                minWindow = returnHolder.str;
            }
            si = returnHolder.index+1;
        }
        return minWindow;

    }

    private static ReturnHolder findWindow(String s, String t, int si) {
        System.out.println("findWindow s = " + s + ", t = " + t + ", si = " + si);
        int ti = 0;
        while (si < s.length()) {
            if (s.charAt(si) == t.charAt(ti)) {
                if (ti == t.length() - 1) {
                    int st = findBeginningOfSubsequence(s, t, si);
                    return new ReturnHolder(s.substring(st, si + 1), st);
                } else {
                    si++;
                    ti++;
                }
            } else {
                si++;
            }
        }
        return null;
    }

    private static int findBeginningOfSubsequence(String s, String t, int si) {
        System.out.println("findBeginningOfSubsequence s = " + s + ", t = " + t + ", si = " + si);
        int ti = t.length() - 1;
        while (si >= 0 && ti >= 0) {
            System.out.println("findBeginningOfSubsequence si = " + si + " ti = " + ti + ", s.charAt(si) = " + s.charAt(si) + ", t.charAt(ti) = " + t.charAt(ti));
            if (s.charAt(si) == t.charAt(ti)) {
                si--;
                ti--;
            } else {
                si--;
            }
        }
        System.out.println("findBeginningOfSubsequence si = " + si);
        System.out.println("findBeginningOfSubsequence -------------------------------");
        return si + 1;
    }

    // Driver code
    public static void main(String[] args) {
        // Driver code
        String[] str1 = {
                "abcdbebe", "abcdebdde", "abcdedeaqdweq", "fgrqsqsnodwmxzkzxwqegkndaa", "zxcvnhss", "alpha", "beta"
        };
        String[] str2 = {
                "bbe", "bde", "adeq", "kzed", "css", "la", "ab"
        };
        for (int i = 0; i < str1.length; i++) {
            System.out.println(i + 1 + ".\tInput String: " + "(" + str1[i] + ", " + str2[i] + ")");
            System.out.println("\tSubsequence string: " + minWindow(str1[i], str2[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
