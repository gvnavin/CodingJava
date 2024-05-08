package companies.atlassian.costexplorer;

import java.time.LocalDate;

public class UnitYear {

    private LocalDate startDate;
    private LocalDate endDate;

    public UnitYear(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
