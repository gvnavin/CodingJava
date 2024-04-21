package practice.hashmap_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FractionToDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {

        int quo = numerator / denominator;
        int initQuo = quo;

        System.out.println("initQuo = " + initQuo);

        int remainder = numerator % denominator;
        System.out.println("remainder = " + remainder);

        List<Integer> decimals = new ArrayList<>();
        HashMap<Integer, Integer> remainderToIndex = new HashMap<>();

        while (!remainderToIndex.containsKey(remainder)) {
            remainderToIndex.put(remainder, decimals.size());
            remainder = remainder * 10;
            quo = remainder / denominator;
            decimals.add(Math.abs(quo));
            remainder = remainder % denominator;
        }

        StringBuilder sb = new StringBuilder();

        if (numerator < 0 && denominator < 0) {
            sb.append(initQuo);
        } else if (numerator < 0 || denominator < 0){
            if (initQuo < 0) {
                sb.append(initQuo);
            } else {
                sb.append("-");
                sb.append(initQuo);
            }
        } else {
            sb.append(initQuo);
        }


        if (!remainderToIndex.isEmpty()) {
            sb.append('.');
        }

        boolean closeRequired = false;
        for (int i = 0; i < decimals.size(); i++) {
            if (remainderToIndex.getOrDefault(remainder, -1) == i) {
                sb.append("(");
                closeRequired = true;
            }
            sb.append(decimals.get(i));
        }

        if (closeRequired) {
            sb.append(")");
        }

        return sb.toString();
    }

}


