public class SalaryCalculator {

    private double hra;
    private double otherAllowances;
    private double taxDeduction;
    private double otherDeductions;

    public SalaryCalculator(double hra, double otherAllowances,
                            double taxDeduction, double otherDeductions) {

        this.hra = hra;
        this.otherAllowances = otherAllowances;
        this.taxDeduction = taxDeduction;
        this.otherDeductions = otherDeductions;
    }

    public double calculateGrossSalary(Employee employee) {
        return employee.getBasicSalary() + hra + otherAllowances;
    }

    public double calculateTotalDeductions() {
        return taxDeduction + otherDeductions;
    }

    public double calculateNetSalary(Employee employee) {
        return calculateGrossSalary(employee) - calculateTotalDeductions();
    }

    public void displaySalarySlip(Employee employee) {

        System.out.println("\n========== SALARY SLIP ==========");
        System.out.println("Employee ID: " + employee.getEmployeeId());
        System.out.println("Name: " + employee.getName());
        System.out.println("Department: " + employee.getDepartment());

        System.out.printf("Basic Salary: Rs. %.2f%n",
                employee.getBasicSalary());

        System.out.printf("HRA: Rs. %.2f%n", hra);

        System.out.printf("Other Allowances: Rs. %.2f%n",
                otherAllowances);

        System.out.printf("Gross Salary: Rs. %.2f%n",
                calculateGrossSalary(employee));

        System.out.printf("Tax Deduction: Rs. %.2f%n",
                taxDeduction);

        System.out.printf("Other Deductions: Rs. %.2f%n",
                otherDeductions);

        System.out.printf("Total Deductions: Rs. %.2f%n",
                calculateTotalDeductions());

        System.out.printf("Net Salary: Rs. %.2f%n",
                calculateNetSalary(employee));

        System.out.println("=================================");
    }
}