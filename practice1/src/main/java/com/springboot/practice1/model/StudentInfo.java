package com.springboot.practice1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
public class StudentInfo {
    private String name;
    private int age;
    private String city="Nagpur";
}
