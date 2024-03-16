import java.util.Arrays;

public class SortedPivot {

    public static void main(String[] args) {
//        int[] input = new int[]{4, 5, 6, 7, 1, 2, 3};
//        int target = 6;

//        int[] input = new int[]{4, 5, 6, 7, 1, 2, 3};
//        int target = 10;

        int[] input = new int[]{4, 6, 7, 1, 2, 3};
//        int[] input = new int[]{4, 6, 7};
        int target = 5;

        int beg = 0;
        int end = input.length - 1;

        int pivot = -1;
        while (beg < end) {
            int mid = beg + (end - beg) / 2; // avoid integer overflow;
            System.out.println("beg = " + beg + " mid = " + mid + " end = " + end);

            if (mid - 1 >= 0 && input[mid] > input[mid - 1] && mid + 1 < input.length && input[mid] > input[mid + 1]) {
                pivot = mid;
                break;
            } else if (mid - 1 >= 0 && input[mid] > input[mid - 1] && mid + 1 >= input.length) {
                pivot = mid;
                break;
            } else if (mid - 1 < 0 && mid + 1 < input.length && input[mid] > input[mid + 1]) {
                pivot = mid;
                break;
            } else if (input[mid] > input[0]) {
                beg = mid;
            } else if (input[mid] < input[input.length - 1]) {
                end = mid;
            }
        }
        System.out.println("pivot = " + pivot);

        int newBeg = -1;
        int newEnd = -1;
        if (target >= input[0] && target <= input[pivot]) {
            newBeg = 0;
            newEnd = pivot;
        } else if (target >= input[pivot] && target <= input[input.length-1]) {
            newBeg = pivot;
            newEnd = input.length-1;
        }

        if (newBeg == -1 || newEnd == -1) {
            System.out.println("-1"); // not found
            return;
        }

        int output = Arrays.binarySearch(input, newBeg, newEnd, target);

        if (output > 0) {
            System.out.println("output = " + output);
        } else {
            System.out.println("-1");
        }

    }

}
