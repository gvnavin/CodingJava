package practice.dynamicprogramming;

public class PartitionEqualSum {

    public static boolean canPartitionArray(int[] arr) {

        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        if (sum % 2 == 1) {
            return false;
        }

        return recur(arr, sum / 2, 0);

    }

    private static boolean recur(int[] arr, int total, int i) {

        if (total == 0) {
            return true;
        }

        if (i >= arr.length || total < 0) {
            return false;
        }

        boolean include = recur(arr, total-arr[i], i + 1);
        boolean exclude = recur(arr, total, i + 1);

        return include || exclude;
    }

}
