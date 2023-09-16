package com.springboot.mysql.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Student {
    private int studentId;
    private String lastname;
    private String firstname;
    private String contact="9172992890";
    private String branch;
    private String accountStatus="Active";
    private String registeredOn;
    private String password;
    private String city;
    private int studentAge;
}
