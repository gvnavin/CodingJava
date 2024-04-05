package practice.fastslowptrs;

public class HappyNumberFastSlowPointer {

    public static int sumOfSquares(int inp) {
        int sum = 0;
        while(inp > 0) {
            int digit = inp%10;
            inp /= 10;
            sum += (digit * digit);
        }
        return sum;
    }

    public static boolean isHappyNumber(int n) {

        int fast = n;
        int slow = n;

        while(true) {
            fast = sumOfSquares(fast);
            if (fast == 1) {
                return true;
            }
            fast = sumOfSquares(fast);
            if (fast == 1) {
                return true;
            }
            slow = sumOfSquares(slow);
//            if (slow == 1) {
//                return true;
//            }
            if (fast == slow) {
                return false;
            }
        }
    }

}
