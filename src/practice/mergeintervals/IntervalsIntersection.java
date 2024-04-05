package practice.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalsIntersection {
    public static int[][] intervalsIntersection(int[][] inta, int[][] intb) {
        System.out.println("inta = " + Arrays.deepToString(inta) + ", intb = " + Arrays.deepToString(intb));
        int i = 0;
        int j = 0;

        List<int[]> output = new ArrayList<>();
        while (i < inta.length && j < intb.length) {
//            System.out.println("i = " + i + ", j = " + j + ", output = " + output);
            if (inta[i][1] < intb[j][0]) {
                i++;
            } else if (intb[j][1] < inta[i][0]) {
                j++;
            } else if (inta[i][0] <= intb[j][0] && intb[j][0] <= inta[i][1]) {
                output.add(new int[]{
                        Math.max(inta[i][0], intb[j][0]),
                        Math.min(inta[i][1], intb[j][1]),
                });
                if (inta[i][1] < intb[j][1]) {
                    i++;
                } else if (intb[j][1] < inta[i][1]) {
                    j++;
                } else {
                    i++;
                    j++;
                }
            } else if (intb[j][0] <= inta[i][0] && inta[i][0] <= intb[j][1]) {
                output.add(new int[]{
                        Math.max(inta[i][0], intb[j][0]),
                        Math.min(inta[i][1], intb[j][1]),
                });
                if (inta[i][1] < intb[j][1]) {
                    i++;
                } else if (intb[j][1] < inta[i][1]) {
                    j++;
                } else {
                    i++;
                    j++;
                }
            }
        }
        return output.toArray(new int[][]{});
    }

    // Driver code
    public static void main(String args[]) {
        int[][][] inputIntervalLista = {
//                {{1, 2}},
//                {{1, 4}, {5, 6}, {9, 15}},
//                {{3, 6}, {8, 16}, {17, 25}},
                {{4, 7}, {9, 16}, {17, 28}, {39, 50}, {55, 66}, {70, 89}},
                {{1, 3}, {5, 6}, {7, 8}, {12, 15}}
        };

        int[][][] inputIntervalListb = {
//                {{1, 2}},
//                {{2, 4}, {5, 7}, {9, 15}},
//                {{2, 3}, {10, 15}, {18, 23}},
                {{3, 6}, {7, 8}, {9, 10}, {14, 19}, {23, 33}, {35, 40}, {45, 59}, {60, 64}, {68, 76}},
                {{2, 4}, {7, 10}}
        };

        for (int i = 0; i < inputIntervalLista.length; i++) {
            System.out.println(i + 1 + ".\t Interval List A: " + Arrays.deepToString(inputIntervalLista[i]));
            System.out.println("\t Interval List B: " + Arrays.deepToString(inputIntervalListb[i]));
            System.out.println("\t Intersecting intervals in 'A' and 'B' are: " +
                    Arrays.deepToString(intervalsIntersection(inputIntervalLista[i], inputIntervalListb[i])));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
