import java.sql.Array;
import java.util.*;

public class Kotak {

    /**
     * <return_type> shuffle (<argument_type> ){
     *  return;
     * }
     */

    /**
     *
     */

    private static int findSwapPointBinarySearch(int[] arr, int left, int right) {
        // Could do binary search
        while(left < right) {
            int mid = left + (right - left)/2;
            if(arr[mid] <= arr[right] && arr[left] > arr[right]) {
                right = mid; // moving to left half
            } else {
                left = mid + 1; //moving to right half
            }
        }
        return left;
    }

    private static int binarySearch(int[] arr, int left, int right, int target, boolean order) {
        while(left<= right) {
            int mid = left + (right - left)/2;
            if(arr[mid] == target) {
                return mid;
            }
            else if((order && arr[mid] < target) || (!order && arr[mid] > target)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int findIndexInRotatedArray(int[] arr, int target) {
        int swapPoint = findSwapPointBinarySearch(arr, 0, arr.length - 1);
        int leftRes = binarySearch(arr, 0, swapPoint - 1, target, false);
        if(leftRes != -1) return leftRes;
        return binarySearch(arr, swapPoint, arr.length - 1, target, true);
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] { 5, 4, 1, 2, 3};
        System.out.println("Swap Point : "+ findIndexInRotatedArray(arr1, 2));
        System.out.println("Swap Point : "+ findIndexInRotatedArray(arr1, 3));
        System.out.println("Swap Point : "+ findIndexInRotatedArray(arr1, 4));
        System.out.println("Swap Point : "+ findIndexInRotatedArray(arr1, 5));
        System.out.println("Swap Point : "+ findIndexInRotatedArray(arr1, 1));
        System.out.println("Swap Point : "+ findIndexInRotatedArray(arr1, 11));
    }
}


