package practice.knowing_what_to_track;

import java.util.Arrays;
import java.util.Objects;

public class IsAnagramV0 {
    public static boolean isAnagram(String str1, String str2) {

        char[] charArray1 = str1.toCharArray();
        Arrays.sort(charArray1);
        char[] charArray2 = str2.toCharArray();
        Arrays.sort(charArray2);

        String s1 = new String(charArray1);
        String s2 = new String(charArray2);

        return Objects.equals(s1, s2);
    }
}
