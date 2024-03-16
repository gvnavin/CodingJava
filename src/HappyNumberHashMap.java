import java.util.*;

public class HappyNumberHashMap {

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

        HashSet<Integer> hs = new HashSet<Integer>();

        do {
            if (hs.contains(n)) {
                return false;
            }
            hs.add(n);
            n = sumOfSquares(n);
        } while(n > 1);

        return true;
    }
}
