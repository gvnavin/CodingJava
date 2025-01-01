import java.util.Arrays;

public class SavingsAccountInterestCalculator {

    public static void main(String[] args) {

        computeRealReturns(new double[][] {
            {1, 3.0},
            {7, 5.0},
            {250, 7.0},
            {500, 7.8}
        }, 25);

        computeRealReturns(new double[][] {
            {1, 3.0},
            {3, 3.0},
            {5, 4.0},
            {10, 5.0},
            {25, 7.0},
            {100, 7.8}
        }, 25);
    }

    private static void computeRealReturns(double[][] slabs, double totalAmount) {
        double returns  = 0;
        double prevSlabEnd = 0;
        for(double[] slab : slabs) {
            double upperBound = slab[0], rate = slab[1];
            double amountInRange = Math.min(upperBound, totalAmount) - prevSlabEnd;
            if(amountInRange <= 0) {
                break;
            }
            // System.out.println("At slab : "+ Arrays.toString(slab)+", getting : "+((amountInRange * rate) / 100));
            returns += (amountInRange * rate) / 100;
            prevSlabEnd = upperBound;
        }
        System.out.println("Returns : "+returns);
        double realReturns = (returns / totalAmount) * 100;
        System.out.println("Return Percentage : "+realReturns);
    }
}
