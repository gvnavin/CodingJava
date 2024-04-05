package practice.slidingwindow;

public class MaxProfit {

    public static int maxProfit(int[] prices) {

        int min = Integer.MAX_VALUE;
        int maxProf = 0;

        for (int i = 0; i < prices.length; i++) {
            int prof = prices[i] - min;
            if (prof > maxProf) {
                maxProf = prof;
            }
            if (prices[i] < min) {
                min = prices[i];
            }
        }


        return maxProf;
    }

}