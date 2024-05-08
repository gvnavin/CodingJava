package companies.atlassian.costexplorer;

public class Plan {

    private String planId;
    private double price;

    public Plan(String planId, double price) {
        this.planId = planId;
        this.price = price;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
