package atlassian;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class CostExplorer {

    public static final int NO_OF_MONTH = 12;
    private Offering offering;
    private UnitYear unitYear;

    public CostExplorer(Offering offering, UnitYear unitYear) {
        this.offering = offering;
        this.unitYear = unitYear;
    }

    public List<Double> monthlyCostList(List<InputRequest> inputRequests) {

        List<List<Double>> monthlyPrices = new ArrayList<>();
        for (int i = 0; i < inputRequests.size(); i++) {
            List<Double> monthlyCostList = monthlyCostList(inputRequests.get(i).getPlanId(), inputRequests.get(i).getStartDate());
            monthlyPrices.add(monthlyCostList);
        }

        List<Double> monthlyPricesToReturn = new ArrayList<>();
        for (int j = 0; j < 12; j++) {
            double overallPricesForOneMonth = 0.0;
            for (int i = 0; i < monthlyPrices.size(); i++) {
                overallPricesForOneMonth += monthlyPrices.get(i).get(j);
            }
            monthlyPricesToReturn.add(overallPricesForOneMonth);
        }

        return monthlyPricesToReturn;
    }

    public List<Double> monthlyCostList(String planId, LocalDate startDate) {

        int daysRemainingInGivenMonth = computeDaysRemainingInGivenMonth(startDate);
        Plan plan = offering.getPlanById(planId);
        double pricePerDay = computePricePerDay(startDate, plan);
        double priceForRemainingDays = pricePerDay * ((double) daysRemainingInGivenMonth);

        int startOfUnitYear = unitYear.getStartDate().getMonthValue();
        int subStartMonth = startDate.getMonthValue();

        int previousMonths = subStartMonth - startOfUnitYear;

        List<Double> monthlyPrices = new ArrayList<>();
        for (int i = 0; i < previousMonths; i++) {
            monthlyPrices.add(0.0);
        }
        monthlyPrices.add(priceForRemainingDays);

        for (int i = previousMonths + 1; i < NO_OF_MONTH; i++) {
            monthlyPrices.add(plan.getPrice());
        }

        return monthlyPrices;
    }


    //utils
    private double computePricePerDay(LocalDate startDate, Plan plan) {
        return plan.getPrice() / getNumberOfDaysInMonth(startDate.getMonth());
    }

    private int computeDaysRemainingInGivenMonth(LocalDate startDate) {
        Month month = startDate.getMonth();
        int numberOfDaysInMonth = getNumberOfDaysInMonth(month);
        int dayOfMonth = startDate.getDayOfMonth();
        return numberOfDaysInMonth - dayOfMonth + 1;
    }

    private int getNumberOfDaysInMonth(Month month) {
        //we can extend this further
        return 30;
    }

    public double annualCost(String planId, LocalDate startDate) {
        List<Double> monthlyCostList = monthlyCostList(planId, startDate);
        double sum = 0.0;
        for (Double monthCost : monthlyCostList) {
            sum += monthCost;
        }
        return sum;
    }

}
