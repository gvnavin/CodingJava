package mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static int[][] merge(int[] int1, int[] int2) {
        if (int1[1] < int2[0]) {
            int[][] allIntervals = {int1, int2};
            return allIntervals;
        }

        if (int2[1] < int1[0]) {
            int[][] allIntervals = {int2, int1};
            return allIntervals;
        }

        if (int1[0] <= int2[0] &&  int2[0] <= int1[1]) {
            int[][] allIntervals = {{Math.min(int1[0], int2[0]), Math.max(int1[1], int2[1])}};
            return allIntervals;
        }

        if (int2[0] <= int1[0] &&  int1[0] <= int2[1]) {
            int[][] allIntervals = {{Math.min(int1[0], int2[0]), Math.max(int1[1], int2[1])}};
            return allIntervals;
        }

        return new int[][]{{}};
    }

    public static int[][] mergeIntervals(int[][] intervals) {

        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[][] merge = merge(merged.get(merged.size() - 1), intervals[i]);
            merged.remove(merged.size()-1);

            for (int j = 0; j < merge.length; j++) {
                merged.add(merge[j]);
            }
        }

        int[][] array = merged.toArray(new int[][]{});
        return array;
    }

    public static void main(String[] args) {
        int[][][] allIntervals = {
                {{1, 5}, {3, 7}, {4, 6}},
                {{1, 5}, {4, 6}, {6, 8}, {11, 15}},
                {{3, 7}, {6, 8}, {10, 12}, {11, 15}},
                {{1, 5}},
                {{1, 9}, {3, 8}, {4, 4}},
                {{1, 2}, {3, 4}, {8, 8}},
                {{1, 5}, {1, 3}},
                {{1, 5}, {6, 9}},
                {{0, 0}, {1, 18}, {1, 3}}
        };

        for (int i = 0; i < allIntervals.length; i++) {
            System.out.println(i + 1 + ".\tIntervals to merge: " + Arrays.deepToString(allIntervals[i]));
            int[][] result = mergeIntervals(allIntervals[i]);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
