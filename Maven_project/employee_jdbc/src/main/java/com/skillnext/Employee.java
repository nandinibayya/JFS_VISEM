package com.skillnext;

public class Employee {

    private int id;
    private String name;
    private String email;
    private double salary;

    // Constructor for inserting (id is auto-generated)
    public Employee(String name, String email, double salary) {
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    // Constructor for fetching from DB
    public Employee(int id, String name, String email, double salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id +
                ", name=" + name +
                ", email=" + email +
                ", salary=" + salary + "]";
    }
}
