package mergeksorted;

public class MergeSortedV0 {

    public static int[] mergeSorted(int[] nums1, int m, int[] nums2, int n) {

        int i1 = m-1;
        int i2 = n-1;

        int ri = nums1.length-1;

        while (i1 >= 0 && i2 >= 0) {
            if (nums1[i1] > nums2[i2]) {
                nums1[ri] = nums1[i1];
                i1--;
            } else {
                nums1[ri] = nums2[i2];
                i2--;
            }
            ri--;
        }

        while (i1 >= 0) {
            nums1[ri] = nums1[i1];
            i1--;
            ri--;
        }

        while (i2 >= 0) {
            nums1[ri] = nums2[i2];
            i2--;
            ri--;
        }

        return nums1;
    }

}
