package com.fan.entity;

/**
 * @author y
 */
public class Salary {
    private int id;
    private double salary;
    private int emp_id;

    public Salary(int id, double salary, int emp_id) {
        this.id = id;
        this.salary = salary;
        this.emp_id = emp_id;
    }

    public Salary() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", salary=" + salary +
                ", emp_id=" + emp_id +
                '}';
    }
}
