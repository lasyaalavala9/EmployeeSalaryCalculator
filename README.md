# Employee Salary Calculator

A console-based application built using Core Java to manage employee details and calculate salaries.

## About the Project

The Employee Salary Calculator allows users to add employee information, view employee records, search for employees by ID, and generate salary slips based on basic salary, allowances, and deductions.

This project was developed to practise Core Java, Object-Oriented Programming (OOP), collections, and file handling.

## Features

- Add employee details
- View all employees
- Search employees using employee ID
- Calculate gross salary
- Calculate total deductions
- Calculate net salary
- Generate employee salary slips
- Store employee information in a text file
- Prevent duplicate employee IDs

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- ArrayList
- Exception handling
- File handling
- Git and GitHub

## Salary Calculation

**Gross Salary**

Gross Salary = Basic Salary + HRA + Other Allowances

**Total Deductions**

Total Deductions = Tax Deduction + Other Deductions

**Net Salary**

Net Salary = Gross Salary - Total Deductions

## Project Structure

```text
EmployeeSalaryCalculator/
├── src/
│   ├── Employee.java
│   ├── SalaryCalculator.java
│   ├── FileManager.java
│   └── Main.java
├── data/
│   └── employees.txt
├── .gitignore
└── README.md
```

## How to Run

1. Install the Java Development Kit (JDK).
2. Open a terminal in the project folder.
3. Compile the Java source files:

   ```bash
   javac -d out src/*.java
   ```

4. Run the application:

   ```bash
   java -cp out Main
   ```

## Learning Outcomes

- Practised classes, objects, constructors, and encapsulation.
- Used an ArrayList to manage employee records.
- Implemented salary calculations using separate methods.
- Used file handling to save and load employee information.
- Used Git and GitHub for version control.
