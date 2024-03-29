package topkelements;

import java.util.*;

public class FrequentWords {

    public static int stringCompare(String str1, String str2)
    {
        for (int i = 0; i < str1.length() && i < str2.length(); i++) {
            if ((int)str1.charAt(i) == (int)str2.charAt(i)) {
                continue;
            }
            else {
                return (int)str1.charAt(i) - (int)str2.charAt(i);
            }
        }

        return (str2.length()-str1.length());

    }

    static class Node implements Comparable<Node> {
        String value;
        int cnt;

        public Node(String value, int cnt) {
            this.value = value;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value='" + value + '\'' +
                    ", cnt=" + cnt +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            if (this.cnt != o.cnt) {
                return this.cnt - o.cnt;
            }
            //reverse
            return stringCompare(this.value, o.value) * -1;
        }


    }

    public static List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> wordToCntMap = new HashMap<>();

        for (String word : words) {
            Integer cnt = wordToCntMap.getOrDefault(word, 0);
            wordToCntMap.put(word, cnt+1);
        }

//        System.out.println("wordToCntMap = " + wordToCntMap);

        PriorityQueue<Node> q = new PriorityQueue<>();

        for (Map.Entry<String, Integer> ent : wordToCntMap.entrySet()) {
            Node node = new Node(ent.getKey(), ent.getValue());

//            System.out.println("-----s-------");
//            System.out.println(q);
//            System.out.println(node);
//            System.out.println("-----e-------");

            if (q.size() < k) {
                q.add(node);
                continue;
            }

            if (q.peek().cnt < ent.getValue()) {
                q.poll();
                q.add(node);
            } else if (q.peek().cnt == ent.getValue()) {
//                System.out.println("-----inside start else if-------");
//                System.out.println(q);
//                System.out.println(node);
//                System.out.println("-----inside end else if-------");

                if(stringCompare(node.value, q.peek().value) < 0) {
                    q.poll();
                    q.add(node);
                }
            }
        }

        System.out.println("q = " + q);

        ArrayList<String> ret = new ArrayList<>();
        while (!q.isEmpty()) {
            ret.add(0, q.poll().value);
        }

        return ret;
    }

}
