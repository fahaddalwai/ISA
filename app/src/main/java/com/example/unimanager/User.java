package com.example.unimanager;

public class User {

    public String email;
    public String registrationnumber;
    public int contactnumber;
    public String college;
    public String branch;


    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(com.example.unimanager.User.class)
    }

    public User(String email, String registrationnumber, int contactnumber, String college, String branch) {
        this.email = email;
        this.registrationnumber = registrationnumber;
        this.contactnumber = contactnumber;
        this.college = college;
        this.branch = branch;
    }
}
