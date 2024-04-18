package atlassian;

import java.util.ArrayList;
import java.util.List;

public class Offering {

    //hashmap as well
    private List<Plan> plans;

    public Offering() {
        this.plans = new ArrayList<>();
    }

    public Offering(List<Plan> plans) {
        this.plans = plans;
    }

    public List<Plan> getPlans() {
        return plans;
    }

    public void setPlans(List<Plan> plans) {
        this.plans = plans;
    }

    public void addPlan(Plan plan) {
        this.plans.add(plan);
    }

    public Plan getPlanById(String id) {
        //optimization hash map
        for (Plan plan : plans) {
            if (plan.getPlanId().equals(id)) {
                return plan;
            }
        }
        throw new IllegalArgumentException("no plan id is present");
    }

}
