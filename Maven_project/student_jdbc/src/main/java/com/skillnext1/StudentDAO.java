package com.skillnext1;

import java.sql.*;
import java.util.*;

public class StudentDAO {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/skillnext_db";
    private static final String USER = "root";
    private static final String PASSWORD = "PRISCILLA2006"; // change this

    // Add employee
    public void addStudent(Student stu) throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "INSERT INTO student(id, name, sem, department) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, stu.getId());
        stmt.setString(2, stu.getName());
        stmt.setInt(3, stu.getSem());
        stmt.setString(4, stu.getDepartment());
        stmt.executeUpdate();
        conn.close();
    }
    
    // Fetch all employees
    public List<Student> getAllStudents() throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM student");

        List<Student> list = new ArrayList<>();
        while (rs.next()) {
            Student s = new Student();
            s.setId(rs.getInt("id"));
            s.setName(rs.getString("name"));
            s.setSem(rs.getInt("sem"));
            s.setDepartment(rs.getString("department"));
            list.add(s);
        }
        conn.close();
        return list;
    }

    // Delete employee
    public void deleteStudent(int id) throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "DELETE FROM employee WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        conn.close();
    }

    // Update employee
    public void updateStudent(Student stu) throws Exception {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        String sql = "UPDATE employee SET name=?, email=?, salary=? WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, stu.getName());
        stmt.setInt(2, stu.getSem());
        stmt.setString(3, stu.getDepartment());
        stmt.setInt(4, stu.getId());
        stmt.executeUpdate();
        conn.close();
    }
}