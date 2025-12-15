package com.skillnext1;

public class Student {
    private int id;
    private String name;
    private int sem;
    private String department;

    // Constructors
    public Student() {}
    public Student(int id, String name, int sem, String department) {
         this.id = id;
        this.name = name;
        this.sem = sem;
        this.department = department;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getSem() { return sem; }
    public void setSem(int sem) { this.sem = sem; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", sem=" + sem + ", department=" + department + "]";
    }
}