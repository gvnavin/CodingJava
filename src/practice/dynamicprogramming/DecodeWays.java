package practice.dynamicprogramming;

public class DecodeWays {

    public static int numOfDecodings(String decodeStr) {
        if (decodeStr.startsWith("0")) {
            return 0;
        }
        return recur(decodeStr, 0);
    }
    public static int recur(String decodeStr, int i) {
        if (i == decodeStr.length()) {
            return 1;
        }
        if (i > decodeStr.length()) {
            return 0;
        }

        if (decodeStr.charAt(i) == '1') {
            int cnt1 = recur(decodeStr, i + 1);
            int cnt2 = recur(decodeStr, i + 2);
            return cnt1 + cnt2;
        } else if (decodeStr.charAt(i) == '2') {
            int cnt1 = recur(decodeStr, i + 1);
            int cnt2 = 0;
            if (i + 1 < decodeStr.length() && decodeStr.charAt(i + 1) >= '0' && decodeStr.charAt(i + 1) <= '6') {
                cnt2 = recur(decodeStr, i + 2);
            }
            return cnt1 + cnt2;
        } else if (decodeStr.charAt(i) == '0'){
            return 0;
        } else {
            return recur(decodeStr, i + 1);
        }

    }

}
