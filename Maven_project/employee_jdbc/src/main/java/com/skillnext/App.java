package com.skillnext;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        try {
            EmployeeDAO dao = new EmployeeDAO();
            Scanner sc = new Scanner(System.in);

            // INSERT EMPLOYEE
            System.out.println("Enter employee name:");
            String name = sc.nextLine();

            System.out.println("Enter employee email:");
            String email = sc.nextLine();

            System.out.println("Enter employee salary:");
            double salary = sc.nextDouble();

            Employee emp = new Employee(name, email, salary);
            dao.addEmployee(emp);

            System.out.println("Employee inserted successfully!\n");

            // DISPLAY ALL EMPLOYEES
            List<Employee> employees = dao.getAllEmployees();
            for (Employee e : employees) {
                System.out.println(e);
            }

            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
