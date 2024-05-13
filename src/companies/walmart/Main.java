package companies.walmart;

import java.util.Arrays;

/**
 * Write a function that takes in a non-empty array of integers and returns an array of the same length,
 * where each element in the output array is equal to the product of every other number in the input array.
 * In other words, the value at output [i] is equal to the product of every number in the input array other than input [i]
 * <p>
 * Note that you're expected to solve this problem without using division.
 * <p>
 * Sample Input: array = [5,1,4,2]
 * <p>
 * Sample Output: [8,40,10,20]
 * <p>
 * 0(n) - with division
 * without division
 * 0(n^2) - 2 loops
 * <p>
 * <p>
 * additional space - 0(n)
 * 2 array
 * product of all the elements before i
 * product of all the elements after i
 * TC: 0(n)
 */

public class Main {

    public static void main(String[] args) {
        int[] inp = new int[]{5, 1, 4, 2};
        int[] output = productExceptI(inp);
        System.out.println("Arrays.deepToString(output = " + Arrays.toString(output));

        int[] inp1 = new int[]{5};
        int[] output1 = productExceptI(inp1);
        System.out.println("Arrays.deepToString(output = " + Arrays.toString(output1));

    }

    public static int[] productExceptI(int[] inp) {

        if (inp.length == 0) {
            return new int[0];
        }

        if (inp.length == 1) {
            int[] ret = new int[1];
            ret[0] = 1;
            return ret;
        }

        int[] productFromBeg = new int[inp.length];
        int[] productFromEnd = new int[inp.length];

        productFromBeg[0] = inp[0];
        for (int i = 1; i < inp.length; i++) {
            productFromBeg[i] = productFromBeg[i-1] * inp[i];
        }

        productFromEnd[inp.length - 1] = inp[inp.length-1];
        for (int i = inp.length - 2; i >= 0; i--) {
            productFromEnd[i] = inp[i] * productFromEnd[i + 1];
        }

//        System.out.println("Arrays.deepToString(output = " + Arrays.toString(productFromBeg));
//        System.out.println("Arrays.deepToString(output = " + Arrays.toString(productFromEnd));

        int[] retProductExceptI = new int[inp.length];

        for (int i = 0; i < inp.length; i++) {
            if (i > 0 && i + 1 < inp.length) {
                retProductExceptI[i] = productFromBeg[i - 1] * productFromEnd[i + 1];
            } else if (i > 0) {
                retProductExceptI[i] = productFromBeg[i - 1];
            } else if (i + 1 < inp.length) {
                retProductExceptI[i] = productFromEnd[i + 1];
            }
        }

        return retProductExceptI;

    }

}
