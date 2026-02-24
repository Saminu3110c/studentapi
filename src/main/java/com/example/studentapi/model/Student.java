package com.example.studentapi.model;

public class Student {

    private Integer id;
    private String name;
    private String email;
    private int age;

    public Student() {}

    public Student(Integer id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    // getters and setters
}