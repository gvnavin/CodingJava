package practice.slidingwindow;

import java.util.*;

public class MinSubsequenceInCorrectImplementation {

    public static class IndAndVal {
        public int ind;
        public char c;

        public IndAndVal(int ind, char c) {
            this.ind = ind;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            IndAndVal indAndVal = (IndAndVal) o;
            return ind == indAndVal.ind && c == indAndVal.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(ind, c);
        }

        @Override
        public String toString() {
            return "IndAndVal{" +
                    "ind=" + ind +
                    ", c=" + c +
                    '}';
        }
    }

    static class CustomHashMap {
        HashSet<IndAndVal> hs = new HashSet<IndAndVal>();
        HashMap<Character, Integer> hm = new HashMap<>();

        public int getSize() {
            return hs.size();
        }

        public int getFreqCnt(Character c) {
            return hm.getOrDefault(c, 0);
        }

        public void remove(IndAndVal indAndVal) {
            hs.remove(indAndVal);
            int cnt = hm.get(indAndVal.c);
            hm.put(indAndVal.c, cnt-1);
        }

        public void put(IndAndVal indAndVal) {
            hs.add(indAndVal);
            int cnt = hm.getOrDefault(indAndVal.c, 0);
            hm.put(indAndVal.c, cnt+1);
        }

    }

    public static boolean check(CustomHashMap chm, HashMap<Character, Integer> hm) {
        for(Map.Entry<Character, Integer> e : hm.entrySet()) {
            System.out.println("check: " + chm.getFreqCnt(e.getKey()) + ", e.getKey() : " + e.getKey() + " " + e.getValue());
            if (chm.getFreqCnt(e.getKey()) < e.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static String minWindow(String s, String t) {

        CustomHashMap chm = new CustomHashMap();

        HashMap<Character, Integer> ths = new HashMap<>();
        for(int i=0; i < t.length(); i++) {
            char c = t.charAt(i);
            int cnt = ths.getOrDefault(c, 0);
            ths.put(c, cnt+1);
        }

        //initial beg and end
        int beg = 0;
        int end = -1;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (ths.containsKey(c)) {
                beg = i;
                chm.put(new IndAndVal(i, c));
                if (chm.getFreqCnt(c) >= ths.get(c) && chm.getSize() >= t.length()) {
//                    System.out.println("4. i : " + i + " c: " + c);
                    if (check(chm, ths)) {
//                        System.out.println("5. i : " + i + " c: " + c);
                        end = i;
                        break;
                    }
                }
                break;
            }
        }

        if (end == -1) {
            end = beg + 1;
//     System.out.println("1. initial beg: " + beg + " end: " + end + "  " + s.substring(beg, end));

            for(int i = end; i < s.length(); i++) {
                char c = s.charAt(i);
//            System.out.println("2. i : " + i + " c: " + c);
                if (ths.containsKey(c)) {
                    System.out.println("3. i : " + i + " c: " + c);
                    chm.put(new IndAndVal(i, c));
                    if (chm.getFreqCnt(c) >= ths.get(c) && chm.getSize() >= t.length()) {
//                    System.out.println("4. i : " + i + " c: " + c);
                        if (check(chm, ths)) {
//                        System.out.println("5. i : " + i + " c: " + c);
                            end = i;
                            break;
                        }
                    }
                }
//            System.out.println("----------------");
            }

//        System.out.println("initial beg: " + beg + " end: " + end + "  " + s.substring(beg, end));

        }

        int minBeg = beg;
        int minEnd = end;
        int minLen = end-beg+1;

        while(beg < end && end < s.length()) {

            System.out.println("while beg: " + beg + " end: " + end);

            if (check(chm, ths)) {
                int newLen = end-beg+1;
                if (newLen < minLen) {
                    minBeg = beg;
                    minEnd = end;
                }
                if (ths.containsKey(s.charAt(beg))) {
                    chm.remove(new IndAndVal(beg, s.charAt(beg)));
                }
                beg++;
            } else {
                end++;
                if (end < s.length()) {
                    if (ths.containsKey(s.charAt(end))) {
                        chm.put(new IndAndVal(end, s.charAt(end)));
                    }
                }
            }
        }

        System.out.println("ret beg: " + minBeg + " end: " + minEnd + "  " + s.substring(minBeg, minEnd+1));

        return s.substring(minBeg, minEnd+1);
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
