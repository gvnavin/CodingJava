package practice.slidingwindow_dynamic;

public class MinimumSubArraySum {
    public static int minSubArrayLen(int target, int[] nums) {

        int beg = 0;
        int end = 0;

        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        while (beg <= end && end < nums.length) {
            sum += nums[end];
            while (sum >= target) {
                minLen = Math.min(minLen, end - beg + 1);
                sum -= nums[beg];
                beg++;
            }
            end++;
        }

        if (minLen == Integer.MAX_VALUE) {
            return 0;
        }

        return minLen;

    }
}
