package practice.knowing_what_to_track;

public class PermutePalindrome {
    public static boolean permutePalindrome(String st) {
        int[] cnt = new int[26];
        for (int i = 0; i < st.length(); i++) {
            char c = st.charAt(i);
            cnt[c - 'a']++;
        }

        int noOfOdds = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 == 1) {
                noOfOdds++;
            }
        }

        return noOfOdds <= 1;
    }
}
