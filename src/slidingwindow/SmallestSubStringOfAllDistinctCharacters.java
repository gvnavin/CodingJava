package slidingwindow;

import java.util.*;

/**
 * characters -  a to z - smallest substring all the distinct characters in the string
 * ex:
 * input: abcaad
 * output: bcaad
 */
public class SmallestSubStringOfAllDistinctCharacters {

    public static void main(String[] args) {
//        String input = "abcaad";
//        String input = "abcaada";
        String input = "aaaa";

        Set<Character> uniqChars = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            uniqChars.add(c);
        }

//        System.out.println("uniqChars.size() = " + uniqChars.size());

        Set<Character> slidingWindowUniqChars = new HashSet<>();
        Map<Character, List<Integer>> charToIndexesMap = new HashMap<>();
        int beg = 0;
        int end = 0;

        String output = "";
        int length = Integer.MAX_VALUE;

        while (end < input.length()) {

            System.out.println("beg = " + beg + " end = " + end + " slidingWindowUniqChars = " + slidingWindowUniqChars + " output = " + output + " charToIndexesMap = " + charToIndexesMap);
//            System.out.println("slidingWindowUniqChars.size() < uniqChars.size() = " + (slidingWindowUniqChars.size() < uniqChars.size()));

            if (slidingWindowUniqChars.size() < uniqChars.size()) {
                char c = input.charAt(end);
                slidingWindowUniqChars.add(c);

                List<Integer> indexes = charToIndexesMap.getOrDefault(c, new ArrayList<>());
                indexes.add(end);

                charToIndexesMap.put(c, indexes);

                end++;
            } else if (slidingWindowUniqChars.size() == uniqChars.size()) {
                char c = input.charAt(beg);
                if (end - beg < length) {
                    length = end - beg;
                    output = input.substring(beg, end);
                }

                List<Integer> indexes = charToIndexesMap.getOrDefault(c, Collections.emptyList());
                indexes.remove(Integer.valueOf(beg));

                charToIndexesMap.put(c, indexes);

                if (indexes.isEmpty()) {
                    slidingWindowUniqChars.remove(c);
                }
                beg++;
            } else {
                System.out.println("Should not happen");
            }
        }

        System.out.println("beg = " + beg);
        System.out.println("end = " + end);

        while (beg < input.length()) {
            if (slidingWindowUniqChars.size() == uniqChars.size()) {
                char c = input.charAt(beg);
                if (end - beg < length) {
                    length = end - beg;
                    output = input.substring(beg);
                }

                List<Integer> indexes = charToIndexesMap.getOrDefault(c, Collections.emptyList());
                indexes.remove(Integer.valueOf(beg));
                charToIndexesMap.put(c, indexes);

                if (indexes.isEmpty()) {
                    slidingWindowUniqChars.remove(c);
                }
                beg++;
            } else {
                break;
            }
        }


        System.out.println("output = " + output);

    }

}
