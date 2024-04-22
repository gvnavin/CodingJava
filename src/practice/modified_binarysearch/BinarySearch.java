package practice.modified_binarysearch;

public class BinarySearch {
    public static int binarySearch(int[] nums, int target) {

        int beg = 0;
        int end = nums.length - 1;
        while (beg <= end) {
            int mid = beg + (end - beg) / 2;
            System.out.println("beg = " + beg + " mid = " + mid + " end = " + end);
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                beg = mid + 1;
            }
        }

        return -1;
    }
}
