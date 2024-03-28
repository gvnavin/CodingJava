package mergeksorted;

public class MergeSorted {

    public static int[] mergeSorted(int[] nums1, int m, int[] nums2, int n) {

        int i1 = 0;
        int i2 = 0;

        int[] ret = new int[nums1.length + nums2.length];
        int ri = 0;

        while (i1 < nums1.length && i2 < nums1.length) {
            if (nums1[i1] < nums2[i2]) {
                ret[ri] = nums1[i1];
                i1++;
            } else {
                ret[ri] = nums1[i2];
                i2++;
            }
            ri++;
        }

        while (i1 < nums1.length) {
            ret[ri] = nums1[i1];
            i1++;
            ri++;
        }

        while (i2 < nums2.length) {
            ret[ri] = nums2[i2];
            i2++;
            ri++;
        }

        return ret;
    }

}
