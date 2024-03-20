package slidingwindow;

import java.util.Arrays;

public class MinimumSubArraySum {

    public static int minSubArrayLen(int target, int[] nums) {

        int beg = 0;
        int end = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        while (end < nums.length) {

            System.out.println("beg = " + beg + ", end = " + end + ", minLength = " + minLength);

            if (sum + nums[end] == target) {
                if (end - beg + 1 < minLength) {
                    minLength = end - beg + 1;
                }
                sum += nums[end];
                end++;
            } else if (sum + nums[end] < target) {
                sum += nums[end];
                end++;
            } else {
                sum -= nums[beg];
                beg++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            minLength = 0;
        }

        return minLength;
    }

    // Driver code
    public static void main(String[] args) {
        int[] target = {7, 4, 11, 10, 5, 15};
        int[][] inputArr = {
                {2, 3, 1, 2, 4, 3},
                {1, 4, 4},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 2, 3, 4},
                {1, 2, 1, 3},
                {5, 4, 9, 8, 11, 3, 7, 12, 15, 44}
        };
        for (int i = 0; i < target.length; i++) {
            int windowSize = minSubArrayLen(target[i], inputArr[i]);
            System.out.print((i + 1) + ".\tInput array: " + Arrays.toString(inputArr[i]));
            System.out.print("\n\tTarget: " + target[i]);
            System.out.println("\n\tMinimum Length of Subarray: " + windowSize);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
