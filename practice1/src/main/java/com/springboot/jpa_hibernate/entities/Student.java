package com.springboot.jpa_hibernate.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity(name="Student_Details")
public class Student {
    @Id
    @Column(name = "Student_ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentId;

    @Column(nullable = false, name = "LastName")
    private String lastname;

    @Column(nullable = false, name="FirstName")
    private String firstname;

    private String contact="9172992890";
    private String branch;
    private String accountStatus="Active";
    private long registeredOn= System.currentTimeMillis();
    private String password;
    private String city;
    private int studentAge;
}