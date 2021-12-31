package com.fan.entity;

/**
 * @author y
 */
public class Student {
    private int id;
    private String name;
    private String password;
    //学生需要关联一个老师类
    private Teacher teacher;

    public Student() {
    }

    public Student(int id, String name, String password, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.teacher = teacher;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
