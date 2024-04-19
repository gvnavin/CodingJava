package practice.subsets;
import java.util.*;

public class PermuteWord {

    public static ArrayList<String> permuteWord(String word) {

        ArrayList<String> ret = new ArrayList<>();
        recur(word, "", ret);

        return ret;
    }

    private static void recur(String word, String s, ArrayList<String> ret) {

        if (word.isBlank()) {
            ret.add(s);
            return;
        }

        for (int i = 0; i < word.length(); i++) {
            String tempStr = new String(s);
            tempStr += word.charAt(i);
            String newWord = word.substring(0, i) + word.substring(i + 1);
            recur(newWord, tempStr, ret);
        }
    }
}
