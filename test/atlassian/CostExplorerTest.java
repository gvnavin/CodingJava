package atlassian;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CostExplorerTest {

    public static final String PLAN_BASIC = "BASIC";
    public static final String PLAN_STANDARD = "STANDARD";
    public static final String PLAN_PREMIUM = "PREMIUM";

    @Test
    void monthlyCostList() {

        Offering offering = new Offering();
        offering.addPlan(new Plan(PLAN_BASIC, 9.99));
        offering.addPlan(new Plan(PLAN_STANDARD, 49.99));
        offering.addPlan(new Plan(PLAN_PREMIUM, 249.99));

        UnitYear unitYear = new UnitYear(
                LocalDate.of(2024, Month.JANUARY, 1),
                LocalDate.of(2024, Month.DECEMBER, 30)
        );

        CostExplorer costExplorer = new CostExplorer(offering, unitYear);
        List<Double> actualResponse = costExplorer.monthlyCostList(PLAN_BASIC, LocalDate.of(2024, Month.APRIL, 15));

        List<Double> expectedResponse = Arrays.asList(new Double[]{0.0, 0.0, 0.0, 5.328, 9.99, 9.99, 9.99, 9.99, 9.99, 9.99, 9.99, 9.99});

        System.out.println("doubles = " + actualResponse.size());
        System.out.println("doubles = " + actualResponse);

        Assertions.assertArrayEquals(expectedResponse.toArray(), actualResponse.toArray());

    }

    @Test
    void annualCost() {
    }

    @Test
    void testMonthlyCostListForOnePlan() {
        Offering offering = new Offering();
        offering.addPlan(new Plan(PLAN_BASIC, 9.99));
        offering.addPlan(new Plan(PLAN_STANDARD, 49.99));
        offering.addPlan(new Plan(PLAN_PREMIUM, 249.99));

        UnitYear unitYear = new UnitYear(
                LocalDate.of(2024, Month.JANUARY, 1),
                LocalDate.of(2024, Month.DECEMBER, 30)
        );

        CostExplorer costExplorer = new CostExplorer(offering, unitYear);
        InputRequest inputRequest1 = new InputRequest(PLAN_BASIC, LocalDate.of(2024, Month.APRIL, 15));
        List<InputRequest> inputRequests = new ArrayList<>();
        inputRequests.add(inputRequest1);
        List<Double> actualResponse = costExplorer.monthlyCostList(inputRequests);

        List<Double> expectedResponse = Arrays.asList(new Double[]{0.0, 0.0, 0.0, 5.328, 9.99, 9.99, 9.99, 9.99, 9.99, 9.99, 9.99, 9.99});

        System.out.println("doubles = " + actualResponse.size());
        System.out.println("doubles = " + actualResponse);

        Assertions.assertArrayEquals(expectedResponse.toArray(), actualResponse.toArray());
    }

    @Test
    void testMonthlyCostListForMoreThanOnePlan() {
        Offering offering = new Offering();
        offering.addPlan(new Plan(PLAN_BASIC, 9.99));
        offering.addPlan(new Plan(PLAN_STANDARD, 49.99));
        offering.addPlan(new Plan(PLAN_PREMIUM, 249.99));

        UnitYear unitYear = new UnitYear(
                LocalDate.of(2024, Month.JANUARY, 1),
                LocalDate.of(2024, Month.DECEMBER, 30)
        );

        CostExplorer costExplorer = new CostExplorer(offering, unitYear);
        InputRequest inputRequest1 = new InputRequest(PLAN_BASIC, LocalDate.of(2024, Month.APRIL, 15));
        List<InputRequest> inputRequests = new ArrayList<>();
        inputRequests.add(inputRequest1);
        inputRequests.add(inputRequest1);

        List<Double> actualResponse = costExplorer.monthlyCostList(inputRequests);

        List<Double> expectedResponse = Arrays.asList(new Double[]{0.0, 0.0, 0.0, 5.328, 9.99, 9.99, 9.99, 9.99, 9.99, 9.99, 9.99, 9.99});

        System.out.println("doubles = " + actualResponse.size());
        System.out.println("doubles = " + actualResponse);

//        Assertions.assertArrayEquals(expectedResponse.toArray(), actualResponse.toArray());
    }
}