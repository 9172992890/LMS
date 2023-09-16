package com.springboot.libraryManagementSystem.services;

import com.springboot.libraryManagementSystem.entities.Student;
import com.springboot.libraryManagementSystem.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student addStudent(Student student) {
        return (studentRepository.save(student));
    }

    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Iterable<Student> bulkStudentImport(List<Student> student) {
        studentRepository.saveAll(student);
        return studentRepository.findAll();
    }
}