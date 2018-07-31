package com.korolko.salaryplanner.entity;

public class User {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private int age;

    public User() {

    }

    public User(String username) {
        this.username = username;
    }

    public User(String username, String firstName, String lastName, String email, int age) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}
