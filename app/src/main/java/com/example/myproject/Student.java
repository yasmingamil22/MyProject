package com.example.myproject;

public class Student {
    private String name;
    private String phone;
    private String address;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student(String name, String phone, String address) {

        this.name = name;
        this.phone = phone;
        this.address = address;

    }
    public Student(String name) {

        this.name = name;

    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
