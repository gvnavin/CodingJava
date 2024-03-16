package slidingwindow;

import java.util.*;

public class RepeatingCharacter {

    static class Node implements Comparable<Node> {
        char c;
        int freq;

        public Node(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "c=" + c +
                    ", freq=" + freq +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            int oi = o.c - '0';
            int thi = this.c - '0';
            return thi-oi;
        }
    }

    static class SortedHashMap {
        HashMap<Character, Node> hm = new HashMap<>();
        List<Node> sortedList = new ArrayList<>();
//        HashMap<Character, Integer> hmCharToIndex = new HashMap<>();
        int size = 0;

        public void put(char c) {
            if (hm.containsKey(c)) {
                Node node = hm.get(c);
                node.freq++;
                hm.put(c, node);

//                int index = hmCharToIndex.get(c);

                int index = findIndex(c);
                Node nd = sortedList.get(index);
//                nd.freq++;

                int nextIndex = index + 1;
                while (nextIndex < sortedList.size() && nd.freq > sortedList.get(nextIndex).freq) {
                    sortedList.set(nextIndex - 1, sortedList.get(nextIndex));
                    sortedList.set(nextIndex, nd);
//                    hmCharToIndex.put(c, nextIndex);
                    nextIndex++;
                }
            } else {
                Node node = new Node(c, 1);
                hm.put(c, node);
                sortedList.add(0, node);
//                hmCharToIndex.put(c, 0);
            }
            size++;
        }

        private int findIndex(char c) {
            for (int i = 0; i < sortedList.size(); i++) {
                if (sortedList.get(i).c == c) {
                    return i;
                }
            }
            return -1;
        }

        public void remove(char c) {
            if (!hm.containsKey(c)) {
                return;
            }
            Node node = hm.get(c);
            node.freq--;
//            int index = hmCharToIndex.get(c);
            int index = findIndex(c);
            if (node.freq > 0) {
                hm.put(c, node);
                Node nd = sortedList.get(index);
//                nd.freq++;
                int prevIndex = index - 1;
                while (prevIndex > 0 && nd.freq < sortedList.get(prevIndex).freq) {
                    sortedList.set(prevIndex + 1, sortedList.get(prevIndex));
                    sortedList.set(prevIndex, nd);
//                    hmCharToIndex.put(c, prevIndex);
                    prevIndex--;
                }
            } else {
                hm.remove(c);
                sortedList.remove(index);
//                hmCharToIndex.remove(c);
            }
            size--;
        }

        public Node getHighestFrequencyCharNode() {
            if (!sortedList.isEmpty()) {
                return sortedList.get(sortedList.size() - 1);
            } else {
                return new Node(' ', 0);
            }
        }

        public int getSize() {
            return size;
        }

        @Override
        public String toString() {
            return "SortedHashMap{" +
                    "hm=" + hm +
                    ", sortedList=" + sortedList +
//                    ", hmCharToIndex=" + hmCharToIndex +
                    ", size=" + size +
                    '}';
        }
    }

    public static int longestRepeatingCharacterReplacement(String s, int k) {

        int beg = 0;
        int end = 0;
        SortedHashMap shm = new SortedHashMap();
        int maxLength = 0;

        while (true) {
            Node highestFrequencyCharNode = shm.getHighestFrequencyCharNode();
            int maxFreqChar = highestFrequencyCharNode.freq;
            System.out.println("beg : " + beg + ", end : " + end + ", highestFrequencyCharNode = " + highestFrequencyCharNode + ", maxFreqChar = " + maxFreqChar);
            System.out.println("shm = " + shm);
            System.out.println();

            if (maxFreqChar == shm.getSize() || maxFreqChar + k == shm.getSize() || maxFreqChar + k > shm.getSize()) {
                if (shm.getSize() > maxLength) {
                    maxLength = shm.getSize();
                }
                if (end < s.length()) {
                    shm.put(s.charAt(end));
                } else {
                    break;
                }
                end++;
            } else {
                if (beg < s.length()) {
                    shm.remove(s.charAt(beg));
                } else {
                    break;
                }
                beg++;
            }
        }

        return maxLength;
    }

    // Driver code
    public static void main(String[] args) {
        List<String> inputStrings = Arrays.asList("aaaaaaaaaa", "aaacbbbaabab", "aabccbb", "abbcb", "abccde", "abbcab", "bbbbbbbbb");
        List<Integer> k = Arrays.asList(2, 2, 2, 1, 1, 2, 4);

        for (int i = 0; i < inputStrings.size(); ++i) {
            System.out.println((i + 1) + ".\tInput String: '" + inputStrings.get(i) + "'");
            System.out.println("\tk: " + k.get(i));
            System.out.println("\tLength of the longest substring with repeating characters: "
                    + longestRepeatingCharacterReplacement(inputStrings.get(i), k.get(i)));
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }
    }

}
