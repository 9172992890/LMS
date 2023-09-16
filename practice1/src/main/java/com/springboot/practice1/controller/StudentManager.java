package com.springboot.practice1.controller;

import org.springframework.stereotype.Component;

@Component
public class StudentManager {
    public String getInfo(){
        return "Hello inside manager";
    }
}
