package com.skillnext1;

import java.sql.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        // change URL/USER/PASSWORD to match your local DB
        final String URL = "jdbc:mysql://127.0.0.1:3306/skillnext_db";
        final String USER = "root";
        final String PASSWORD = "23951A055R";
        
        try (Scanner sc = new Scanner(System.in)) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {

                StudentDAO dao = new StudentDAO();

                while (true) {
                    System.out.println("\n1.Insert  2.Update  3.Delete  4.Display  5.Exit");
                    int ch = sc.nextInt();

                    if (ch == 1) {
                        System.out.println("Enter id, name, sem, dept:");
                        int id = sc.nextInt();
                        String name = sc.next();
                        int sem = sc.nextInt();
                        String dept = sc.next();

                        Student s = new Student(id, name, sem, dept);
                        dao.addStudent(s);
                        System.out.println("Inserted.");

                    } else if (ch == 2) {
                        System.out.println("Enter id, name, sem, dept to update:");
                        int id = sc.nextInt();
                        String name = sc.next();
                        int sem = sc.nextInt();
                        String dept = sc.next();

                        Student s = new Student(id, name, sem, dept);
                        dao.updateStudent(s);
                        System.out.println("Updated.");

                    } else if (ch == 3) {
                        System.out.println("Enter id to delete:");
                        int id = sc.nextInt();
                        dao.deleteStudent(id);
                        System.out.println("Deleted.");

                    } else if (ch == 4) {
                        List<Student> list = dao.getAllStudents();
                        for (Student s : list) System.out.println(s);

                    } else {
                        System.out.println("Exiting...");
                        break;
                    }
                }

            } // connection auto-closed here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}