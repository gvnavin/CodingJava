package practice;

import java.util.*;

public class HashSetTest {

    public static class IndAndVal {
        public int ind;
        public char c;

        public IndAndVal(int ind, char c) {
            this.ind = ind;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            IndAndVal indAndVal = (IndAndVal) o;
            return ind == indAndVal.ind && c == indAndVal.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(ind, c);
        }

        @Override
        public String toString() {
            return "IndAndVal{" +
                    "ind=" + ind +
                    ", c=" + c +
                    '}';
        }
    }

    static class CustomHashMap {
        HashSet<IndAndVal> hs = new HashSet<IndAndVal>();
        HashMap<Character, Integer> hm = new HashMap<>();

        public int getSize() {
            return hs.size();
        }

        public int getFreqCnt(Character c) {
            return hm.get(c);
        }

        public void remove(IndAndVal indAndVal) {
            hs.remove(indAndVal);
            int cnt = hm.get(indAndVal.c);
            hm.put(indAndVal.c, cnt-1);
        }

        public void put(IndAndVal indAndVal) {
            hs.add(indAndVal);
            int cnt = hm.getOrDefault(indAndVal.c, 0);
            hm.put(indAndVal.c, cnt+1);
        }

    }
    public static void main(String[] args) {
        HashSet<IndAndVal> hs = new HashSet<IndAndVal>();

        hs.add(new IndAndVal(0, 'a'));
        hs.add(new IndAndVal(1, 'a'));

        hs.remove(new IndAndVal(1, 'a'));

        Iterator itr = hs.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());

    }

}
