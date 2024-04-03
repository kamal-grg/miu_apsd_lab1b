import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;
public class Main {
    public static void displayInJson(ArrayList<Employee> emps) {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (Employee emp : emps) {
            String line = String.format("{\"planReferenceNumber\":%s,\"firstName\":\"%s\",\"lastName\":\"%s\"," +
                            "\"yearlySalary\":%2f,\"employeementDate\":\"%s\",\"enrollmentDate\":\"%s\",\"monthlyContribution\":%s},\n",
                    emp.getPensionPlan().getPlanReferenceNumber()==null?"":emp.getPensionPlan().getPlanReferenceNumber(),
                    emp.getFirstName(), emp.getLastName(), emp.getYearlySalary(), emp.getEmploymentDate().toString(),
                    emp.getPensionPlan().getEnrollmentDate()==null?"":emp.getPensionPlan().getEnrollmentDate().toString(),
                    emp.getPensionPlan().getMonthlyContribution()==null?"":emp.getPensionPlan().getMonthlyContribution());
            sb.append(line);
        }
sb.append("]");
        System.out.println(sb.toString());
    }

    public static void main(String args[]) {
        var employees = new ArrayList<Employee>();
        employees.add(new Employee(1, "Daniel", "Agar", LocalDateTime.parse("2018-01-17T12:30:00"),
                105945.50, new PensionPlan(134, LocalDateTime.parse("2023-01-17T12:30:00"), 100.00)));

        employees.add(new Employee(2, "Benard", "Shaw", LocalDateTime.parse("2019-04-03T12:30:00"),
                197750.00, new PensionPlan(null, null, null)));

        employees.add(new Employee(3, "Carly", "Agar", LocalDateTime.parse("2014-05-16T12:30:00"),
                842000.75, new PensionPlan(145, LocalDateTime.parse("2019-11-04T12:30:00"), 1555.50)));

        employees.add(new Employee(4, "Wesley", "Schneider", LocalDateTime.parse("2019-05-02T12:30:00"),
                150000, new PensionPlan(null, null, null)));

        System.out.println("\nEmployee Pensions Planning System");
        System.out.println("\n1. All employee report in Json Format");
        System.out.println("\n2.Monthly Upcoming Enrollees report");
        System.out.println("\n3.Exit");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Choice: ");
        int ch = sc.nextInt();
        if (ch == 1) {
            //display all employees information
            displayInJson(employees);
        } else if (ch == 2) {
            //monthly upcomming report
            // Get current date
            LocalDateTime currentDate = LocalDateTime.now();

            // Calculate the date 5 years ago
            LocalDateTime fiveYearsAgo = currentDate.minusYears(5);

            // Calculate the date of the upcoming month
            LocalDateTime upcomingMonth = currentDate.plusMonths(1);

            // Filter employees who completed 5 years in upcoming next month
            List<Employee> filteredEmployees = employees.stream()
                    .filter(employee -> employee.getEmploymentDate().isBefore(upcomingMonth) &&
                            employee.getEmploymentDate().isAfter(fiveYearsAgo))
                    .sorted(Comparator.comparing(Employee::getLastName)
                            .thenComparing(Comparator.comparing(Employee::getYearlySalary).reversed()))
                    .collect(Collectors.toList());

            ArrayList<Employee> filteredListAsArrayList = new ArrayList<>(filteredEmployees);

            // Print filtered employees
            displayInJson(filteredListAsArrayList);
        } else {
            // Handle other choices
        }
    }
}
