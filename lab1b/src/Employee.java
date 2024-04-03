import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;

class Employee implements Comparable<Employee> {
    private int employeeId;
    private String firstName;
    private String lastName;
    private LocalDateTime employmentDate;
    private double yearlySalary;
    private PensionPlan pensionPlan;

    public Employee(int employeeId, String firstName, String lastName, LocalDateTime employmentDate,
                    double yearlySalary, PensionPlan pensionPlan) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
        this.yearlySalary = yearlySalary;
        this.pensionPlan = pensionPlan;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDateTime getEmploymentDate() {
        return employmentDate;
    }

    public double getYearlySalary() {
        return yearlySalary;
    }

    public PensionPlan getPensionPlan() {
        return pensionPlan;
    }

    @Override
    public int compareTo(Employee otherEmployee) {
        // First, compare by last name ascending
        int lastNameComparison = this.lastName.compareTo(otherEmployee.lastName);
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }
        // If last names are the same, compare by yearly salary descending
        return Double.compare(otherEmployee.yearlySalary, this.yearlySalary);
    }}
