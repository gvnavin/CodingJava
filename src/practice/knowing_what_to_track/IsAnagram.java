package practice.knowing_what_to_track;

public class IsAnagram {
    public static boolean isAnagram(String str1, String str2) {

        int[] c1 = new int[26];
        int[] c2 = new int[26];

        for (int i = 0; i < str1.length(); i++) {
            c1[str1.charAt(i)-'a']++;
        }

        for (int i = 0; i < str2.length(); i++) {
            c2[str2.charAt(i)-'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }

        return true;
    }
}
