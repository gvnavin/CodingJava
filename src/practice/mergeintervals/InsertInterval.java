package practice.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

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

    public static int[][] insertInterval(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new ArrayList<>();
        merged.add(newInterval);
        for (int i = 0; i < intervals.length; i++) {
            int[][] merge = merge(merged.get(merged.size() - 1), intervals[i]);
            merged.remove(merged.size()-1);

            for (int j = 0; j < merge.length; j++) {
                merged.add(merge[j]);
            }
        }

        int[][] array = merged.toArray(new int[][]{});
        return array;
    }

    // Driver code
    public static void main(String[] args) {
        int[][] newIntervals = {
                {5, 7},
                {8, 9},
                {10, 12},
                {1, 3},
                {1, 10}
        };

        int[][][] existingIntervals = {
                {{1, 2}, {3, 5}, {6, 8}},
                {{1, 3}, {5, 7}, {10, 12}},
                {{8, 10}, {12, 15}},
                {{5, 7}, {8, 9}},
                {{3, 5}}
        };

        for (int i = 0; i < newIntervals.length; i++) {
            System.out.print((i + 1) + ".\tExisting intervals: ");
            System.out.println(Arrays.deepToString(existingIntervals[i]));
            System.out.println("\tNew interval: [" + newIntervals[i][0] + ", " + newIntervals[i][1] + "]");
            int[][] output = insertInterval(existingIntervals[i], newIntervals[i]);
            System.out.println("\tUpdated intervals: " + Arrays.deepToString(output));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
