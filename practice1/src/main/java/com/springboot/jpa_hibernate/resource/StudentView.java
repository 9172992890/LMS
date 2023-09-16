package com.springboot.jpa_hibernate.resource;

import com.springboot.jpa_hibernate.entities.Student;
import com.springboot.jpa_hibernate.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("database/api/hibernate")
public class StudentView {
    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<Object> addStudent(@RequestBody Student student){
        return studentService.addNewStudent(student);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getStudent(@PathVariable("id") Integer id){
        return studentService.getStudentById(id);
    }
}
