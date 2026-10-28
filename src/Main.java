import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Employee> employees;
    private static final Scanner scanner = new Scanner(System.in);
    private static final FileManager fileManager = new FileManager();

    public static void main(String[] args) {

        employees = fileManager.loadEmployees();

        int choice;

        do {
            System.out.println("\n===== EMPLOYEE SALARY CALCULATOR =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Generate Salary Slip");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a number from 1 to 5.");
                scanner.next();
                System.out.print("Enter your choice: ");
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;

                case 2:
                    viewEmployees();
                    break;

                case 3:
                    searchEmployee();
                    break;

                case 4:
                    generateSalarySlip();
                    break;

                case 5:
                    fileManager.saveEmployees(employees);
                    System.out.println("Thank you for using the application!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }

    private static void addEmployee() {

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (findEmployeeById(id) != null) {
            System.out.println("An employee with this ID already exists.");
            return;
        }

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Department: ");
        String department = scanner.nextLine().trim();

        System.out.print("Enter Basic Salary: ");
        double basicSalary = scanner.nextDouble();
        scanner.nextLine();

        if (id <= 0 || name.isEmpty() || department.isEmpty()
                || !Double.isFinite(basicSalary) || basicSalary < 0) {
            System.out.println("Invalid employee details.");
            return;
        }

        Employee employee = new Employee(
                id, name, department, basicSalary
        );

        employees.add(employee);
        fileManager.saveEmployees(employees);

        System.out.println("Employee added successfully!");
    }

    private static void viewEmployees() {

        if (employees.isEmpty()) {
            System.out.println("No employee records found.");
            return;
        }

        System.out.println("\n===== EMPLOYEE LIST =====");

        for (Employee employee : employees) {
            System.out.println(
                    "ID: " + employee.getEmployeeId()
                    + " | Name: " + employee.getName()
                    + " | Department: " + employee.getDepartment()
                    + " | Basic Salary: Rs. "
                    + employee.getBasicSalary()
            );
        }
    }

    private static void searchEmployee() {

        System.out.print("Enter Employee ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Employee employee = findEmployeeById(id);

        if (employee == null) {
            System.out.println("Employee not found.");
        } else {
            System.out.println("\nEmployee Found!");
            System.out.println("ID: " + employee.getEmployeeId());
            System.out.println("Name: " + employee.getName());
            System.out.println("Department: " + employee.getDepartment());
            System.out.println("Basic Salary: Rs. "
                    + employee.getBasicSalary());
        }
    }

    private static void generateSalarySlip() {

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Employee employee = findEmployeeById(id);

        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }

        System.out.print("Enter HRA: ");
        double hra = scanner.nextDouble();

        System.out.print("Enter Other Allowances: ");
        double allowances = scanner.nextDouble();

        System.out.print("Enter Tax Deduction: ");
        double tax = scanner.nextDouble();

        System.out.print("Enter Other Deductions: ");
        double deductions = scanner.nextDouble();
        scanner.nextLine();

        if (!Double.isFinite(hra) || !Double.isFinite(allowances)
                || !Double.isFinite(tax) || !Double.isFinite(deductions)
                || hra < 0 || allowances < 0 || tax < 0 || deductions < 0) {
            System.out.println("Salary components cannot be negative or invalid.");
            return;
        }

        SalaryCalculator calculator = new SalaryCalculator(
                hra, allowances, tax, deductions
        );

        calculator.displaySalarySlip(employee);
    }

    private static Employee findEmployeeById(int id) {

        for (Employee employee : employees) {
            if (employee.getEmployeeId() == id) {
                return employee;
            }
        }

        return null;
    }
}