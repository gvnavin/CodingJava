package twoptrs;

import java.util.*;

public class Triplet {

        static class TripletValues {

            int i;
            int j;
            int k;

            public TripletValues(int i, int j, int k) {
                List<Integer> integers = new ArrayList<>();
                integers.add(i);
                integers.add(j);
                integers.add(k);

                // this is only for 3 values, 3 log 3 time complexity always constant.
                Collections.sort(integers);

                this.i = integers.get(0);
                this.j = integers.get(1);
                this.k = integers.get(2);
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                TripletValues that = (TripletValues) o;
                return i == that.i && j == that.j && k == that.k;
            }

            @Override
            public int hashCode() {
                return Objects.hash(i, j, k);
            }

            @Override
            public String toString() {
                return "{" + i + ","+ j + "," + k + '}';
            }
        }

        public static void main(String [] args) {

            int[] input = new int[] {1, 1, 2, 3, 0, -1, -2};

            Map<Integer, List<Integer>> valueToIndexMap = new HashMap<>();
            for (int i = 0; i < input.length; i++) {
                List<Integer> indexes = valueToIndexMap.getOrDefault(input[i], new ArrayList<>());
                indexes.add(i);
                valueToIndexMap.put(input[i], indexes);
            }

            Set<TripletValues> output = new HashSet<>();

            for (int i = 0; i < input.length; i++) {
                for (int j = i+1; j < input.length; j++) {
                    int localSum = input[i] + input[j];
                    int requiredBalanceToSumZero = -1*localSum;
                    if (valueToIndexMap.containsKey(requiredBalanceToSumZero)) {
                        List<Integer> indexes = valueToIndexMap.get(requiredBalanceToSumZero);
                        Set<Integer> indexHashSet = new HashSet<Integer>(indexes);
                        if (indexHashSet.contains(i)) {
                            indexHashSet.remove(i);
                        }
                        if (indexHashSet.contains(j)) {
                            indexHashSet.remove(j);
                        }
                        if (!indexHashSet.isEmpty()) {
                            Iterator<Integer> iterator = indexHashSet.iterator();
                            int thirdIndex = iterator.next();
                            output.add(new TripletValues(input[i], input[j], input[thirdIndex]));
                        }
                    }
                }
            }

            for(TripletValues tv : output) {
                System.out.println(tv);
            }
        }

}
