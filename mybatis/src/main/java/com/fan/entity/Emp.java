package com.fan.entity;

import org.apache.ibatis.type.Alias;

/**
 * @author y
 */
@Alias("Emp")
public class Emp {
    private int id;
    private String name;
    private int age;
    private String bir;
    private Double salary;

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Emp(int id, String name, int age, String bir, Double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.bir = bir;
        this.salary = salary;
    }

    public Emp() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBir() {
        return bir;
    }

    public void setBir(String bir) {
        this.bir = bir;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", bir='" + bir + '\'' +
                ", salary=" + salary +
                '}';
    }
}
