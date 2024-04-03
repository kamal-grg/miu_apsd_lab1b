import java.time.LocalDateTime;

public class PensionPlan {
    private Integer planReferenceNumber;
    private LocalDateTime enrollmentDate;
    private Double monthlyContribution;

    public PensionPlan(Integer planReferenceNumber, LocalDateTime enrollmentDate, Double monthlyContribution) {
        this.planReferenceNumber = planReferenceNumber;
        this.enrollmentDate = enrollmentDate;
        this.monthlyContribution = monthlyContribution;
    }

    public Integer getPlanReferenceNumber() {
        return planReferenceNumber;
    }

    public void setPlanReferenceNumber(int planReferenceNumber) {
        this.planReferenceNumber = planReferenceNumber;
    }

    public LocalDateTime getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDateTime enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Double getMonthlyContribution() {
        return monthlyContribution;
    }

    public void setMonthlyContribution(double monthlyContribution) {
        this.monthlyContribution = monthlyContribution;
    }
}