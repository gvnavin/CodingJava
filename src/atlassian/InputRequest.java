package atlassian;

import java.time.LocalDate;

public class InputRequest {

    private String planId;

    private LocalDate startDate;

    public InputRequest(String planId, LocalDate startDate) {
        this.planId = planId;
        this.startDate = startDate;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
