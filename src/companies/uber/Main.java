package companies.uber;

import java.util.*;

public class Main {

    static class Node {
        String str;
        int level;

        public Node(String str, int level) {
            this.str = str;
            this.level = level;
        }
    }

    int solution(String startStr, String endStr, String[] bank) {

        char[] gene = new char[]{'A', 'C', 'G', 'T'};

        System.out.println("gene = " + gene);

        Set<String> banks = new HashSet<>();
        for (String s : bank) {
            banks.add(s);
        }

        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(startStr, 0));
        Set<String> visited = new HashSet<>();

        while(!q.isEmpty()) {
            Node tNode = q.poll();
            String tStr = tNode.str;

            if (visited.contains(tStr)) {
                continue;
            }
            if (Objects.equals(tStr, endStr)) {
                return tNode.level;
            }
            visited.add(tStr);

            System.out.println("tStr = " + tStr);

            for (int i = 0; i < tStr.length(); i++) {
                for (int j = 0; j < gene.length; j++) {
                    if (tStr.charAt(i) == gene[j]) {
                        continue;
                    }
                    char[] charArray = tStr.toCharArray();
                    charArray[i] = gene[j];
                    String nextStr = new String(charArray);
                    System.out.println("nextStr = " + nextStr);

                    if (banks.contains(nextStr)) {
                        q.offer(new Node(nextStr, tNode.level + 1));
                    } else {
                        System.out.println("not contains in bank");
                    }
                }
                System.out.println("-----");
            }
            System.out.println("---------------");
        }
        return -1;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int solution;
//        solution = main.solution("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"});
//        System.out.println("solution = " + solution);
//        System.out.println("=====================");

//        solution = main.solution("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"});
//        System.out.println("solution = " + solution);
//        System.out.println("=====================");

        solution = main.solution("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"});
        System.out.println("solution = " + solution);
        System.out.println("=====================");
    }

}
