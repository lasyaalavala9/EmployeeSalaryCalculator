public class Employee {

    private int employeeId;
    private String name;
    private String department;
    private double basicSalary;

    public Employee(int employeeId, String name,
                    String department, double basicSalary) {

        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.basicSalary = basicSalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getBasicSalary() {
        return basicSalary;
    }
}