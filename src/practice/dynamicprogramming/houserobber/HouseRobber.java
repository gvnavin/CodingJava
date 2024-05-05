package practice.dynamicprogramming.houserobber;

public class HouseRobber {

    public static int houseRobber(int[] money) {

        int includeFirst = recur(money, 0, money.length-1);
        int includeLast = recur(money, 1, money.length);

        return Math.max(includeFirst, includeLast);
    }

    public static int recur(int[] money, int i, int end) {
        if (i >= end) {
            return 0;
        }

        int include = money[i] + recur(money, i+2, end);
        int exclude = recur(money, i+1, end);

        return Math.max(include, exclude);

    }

}
