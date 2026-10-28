import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String FILE_PATH = "data/employees.txt";

    public void saveEmployees(ArrayList<Employee> employees) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_PATH))) {

            for (Employee employee : employees) {

                writer.write(
                    employee.getEmployeeId() + "," +
                    employee.getName() + "," +
                    employee.getDepartment() + "," +
                    employee.getBasicSalary()
                );

                writer.newLine();
            }

            System.out.println("Employee details saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving employee details: "
                    + e.getMessage());
        }
    }

    public ArrayList<Employee> loadEmployees() {

        ArrayList<Employee> employees = new ArrayList<>();

        File file = new File(FILE_PATH);

        if (!file.exists()) {
            return employees;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] details = line.split(",");

                if (details.length == 4) {

                    int employeeId = Integer.parseInt(details[0]);
                    String name = details[1];
                    String department = details[2];
                    double basicSalary = Double.parseDouble(details[3]);

                    Employee employee = new Employee(
                            employeeId,
                            name,
                            department,
                            basicSalary
                    );

                    employees.add(employee);
                }
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading employee details: "
                    + e.getMessage());
        }

        return employees;
    }
}