import java.util.*;

public class FindRepeatedSequences {

    public static Set<String> findRepeatedSequences(String s, int k) {

        HashMap<String, Integer> seqToCountMap = new HashMap<String, Integer>();

        StringBuilder sb = new StringBuilder(s.substring(0, k));

        int beg=0;
        int end=k-1;

        while(end < s.length()) {
            String str = sb.toString();
            int cnt = seqToCountMap.getOrDefault(str, 0);
            seqToCountMap.put(str, cnt+1);
            sb.deleteCharAt(0);
            beg++;
            end++;
            if (end < s.length()) {
                sb.append(s.charAt(end));
            }
        }

        Set<Map.Entry<String, Integer>> entrySet = seqToCountMap.entrySet();
        Set<String> ret = new HashSet<String>();

        for(Map.Entry<String, Integer> entry : entrySet) {
            if (entry.getValue() > 1) {
                ret.add(entry.getKey());
            }
        }

        return ret;
    }

    // Driver code
    public static void main(String[] args) {
        List<String> inputsString = Arrays.asList("ACGT", "AGACCTAGAC", "AAAAACCCCCAAAAACCCCCC",
                "GGGGGGGGGGGGGGGGGGGGGGGGG", "TTTTTCCCCCCCTTTTTTCCCCCCCTTTTTTT", "TTTTTGGGTTTTCCA",
                "AAAAAACCCCCCCAAAAAAAACCCCCCCTG", "ATATATATATATATAT");
        List<Integer> inputsK = Arrays.asList(3, 3, 8, 12, 10, 14, 10, 6);

        for (int i = 0; i < inputsK.size(); i++) {
            System.out.println((i + 1) + ".\tInput sequence: " + inputsString.get(i) +
                    "\n\tk: " + inputsK.get(i) + "\n");
            findRepeatedSequences(inputsString.get(i), inputsK.get(i));
            System.out.println(Print.repeat("-", 100));
        }
    }

}
