package com.fan.entity;

import java.util.Date;

/**
 * @author y
 */
public class User {
    private int id;
    private String name;
    private Date bir;
    private String address;
    private char sex;

    public User(int id, String name, Date bir, String address, char sex) {
        this.id = id;
        this.name = name;
        this.bir = bir;
        this.address = address;
        this.sex = sex;
    }

    public User() {
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

    public Date getBir() {
        return bir;
    }

    public void setBir(Date bir) {
        this.bir = bir;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bir=" + bir +
                ", address='" + address + '\'' +
                ", sex=" + sex +
                '}';
    }
}
