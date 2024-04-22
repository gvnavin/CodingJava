package practice.modified_binarysearch;

import java.util.*;

public class BinarySearchRotated {

    public static int binarySearchRotated(List<Integer> nums, int target) {

        int beg = 0;
        int end = nums.size() - 1;

        int pivot = -1;
        while (beg <= end) {
            int mid = beg + (end - beg) / 2;
            System.out.println("rotated beg = " + beg + " mid = " + mid + " end = " + end);
            if (mid - 1 >= 0 && mid + 1 < nums.size() &&
                    nums.get(mid - 1) < nums.get(mid) &&
                    nums.get(mid) > nums.get(mid + 1)) {
                pivot = mid;
                break;
            } else if (mid == 0 && mid + 1 < nums.size() && nums.get(mid) > nums.get(mid + 1)) {
                pivot = mid;
                break;
            } else if (mid == nums.size() - 1 && mid - 1 >= 0 && nums.get(mid - 1) < nums.get(mid)) {
                pivot = mid;
                break;
            } else {
                if (nums.get(0) < nums.get(mid)) {
                    beg = mid + 1;
                } else if (nums.get(mid) < nums.get(nums.size() - 1)) {
                    end = mid - 1;
                } else if (beg == end) {
                    pivot = beg;
                    break;
                }
            }
        }

        System.out.println("pivot = " + pivot);

        if (target >= nums.get(0) && target <= nums.get(pivot)) {
            beg = 0;
            end = pivot;
        } else if (pivot + 1 < nums.size() && target >= nums.get(pivot + 1) && target <= nums.get(nums.size() - 1)) {
            beg = pivot + 1;
            end = nums.size() - 1;
        } else {
            return -1;
        }

        System.out.println("beg = " + beg + " end = " + end);

        while (beg <= end) {
            int mid = beg + (end - beg) / 2;
            System.out.println("search beg = " + beg + " mid = " + mid + " end = " + end);
            if (target == nums.get(mid)) {
                return mid;
            } else if (target < nums.get(mid)) {
                end = mid - 1;
            } else {
                beg = mid + 1;
            }
        }
        return -1;
    }

}