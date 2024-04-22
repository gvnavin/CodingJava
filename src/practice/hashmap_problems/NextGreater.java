package practice.hashmap_problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreater {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stk = new Stack<>();
        HashMap<Integer, Integer> valueAndMaxMap = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!stk.isEmpty() && nums2[i] > stk.peek()) {
                Integer temp = stk.pop();
                valueAndMaxMap.put(temp, nums2[i]);
            }
            stk.add(nums2[i]);
        }

        int[] ret = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ret[i] = valueAndMaxMap.getOrDefault(nums1[i], -1);
        }

        return ret;
    }

    // Driver code
    public static void main(String[] args) {
        int[][] A = {
                {2, 4},
                {3, 2, 5},
                {14, 45, 52},
                {1, 3, 2},
                {4, 2},
                {0}
        };
        int[][] B = {
                {1, 2, 3, 4},
                {2, 3, 5, 1},
                {52, 14, 45, 65},
                {1, 3, 2, 4, 5},
                {1, 2, 4, 3},
                {0}
        };

        int x = 1;
        for (int i = 0; i < A.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tNums 1 = " + Arrays.toString(A[i]));
            System.out.println("\tNums 2 = " + Arrays.toString(B[i]));
            System.out.print("");
            System.out.println("\tThe Next Greater Element Array = " + Arrays.toString(nextGreaterElement(A[i], B[i])));
//            System.out.println(PrintHyphens.repeat("-", 100));
        }
    }
}
