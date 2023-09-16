package com.springboot.mysql.resource;

import com.springboot.mysql.datastore.ItemDataStore;
import com.springboot.mysql.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("database/api")
public class StudentResource {
    @Autowired
    private ItemDataStore studentStore;

    @PostMapping("/insert")
    public ResponseEntity<Student> insertStudent(@RequestBody Student student){
       return new ResponseEntity<>(studentStore.addNewStudent(student), HttpStatus.ACCEPTED);
    }
    @GetMapping("/fetch")
    public ResponseEntity<List<Student>> fetchStudentList(){
        return new ResponseEntity<>(studentStore.fetchAllStudents(),HttpStatus.ACCEPTED);
    }
    @GetMapping("fetch/{id}")
    public ResponseEntity<Student> fetchStudent(@PathVariable("id") int studentId){
        return  new ResponseEntity<>(studentStore.getStudentInfo(studentId),HttpStatus.ACCEPTED);
    }

    @GetMapping("delete/{id}")
    public ResponseEntity<List<Student>> deleteStudent(@PathVariable("id") int studentId){
        return new ResponseEntity<>(studentStore.deleteStudent(studentId),HttpStatus.ACCEPTED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") int studentId, @RequestParam String firstname, @RequestParam String lastname,@RequestParam String city){
        return new ResponseEntity<>(studentStore.updateStudent(studentId,firstname,lastname,city),HttpStatus.ACCEPTED);
    }

}
