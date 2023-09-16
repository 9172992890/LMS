package com.springboot.jpa_hibernate.service;

import com.springboot.jpa_hibernate.entities.Student;
import com.springboot.jpa_hibernate.repositories.StudentRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepositories studentRepositories;
    public ResponseEntity<Object> getStudentById(Integer studentId){
        Optional<Student> student =studentRepositories.findById(studentId);
        if(student.isPresent()){
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Student not found",HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> addNewStudent(Student student){
        Student student1= studentRepositories.save(student);
        return new ResponseEntity<>(student1,HttpStatus.CREATED);
    }

}
