package com.springboot.libraryManagementSystem.resources;

import com.springboot.libraryManagementSystem.entities.*;
import com.springboot.libraryManagementSystem.exceptions.InvalidStudentInfoException;
import com.springboot.libraryManagementSystem.services.BookAllocationService;
import com.springboot.libraryManagementSystem.services.BookService;
import com.springboot.libraryManagementSystem.services.LibrarianService;
import com.springboot.libraryManagementSystem.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("library/")
public class LibraryResource {

    @Autowired
    BookAllocationService bookAllocationService;
    @Autowired
    StudentService studentService;
    @Autowired
    BookService bookService;
    @Autowired
    LibrarianService librarianService;
    @PostMapping("/allocation")
    public ResponseEntity<Object> allocateBook(@RequestBody AllocationRequest allocationRequest){
        BookAllocation bookAllocation=bookAllocationService.addBookAllocationDetails(allocationRequest);
        if(bookAllocation==null){
            throw new InvalidStudentInfoException();
        }
        return new ResponseEntity<>("Inserted Successfully:"+bookAllocation, HttpStatus.CREATED);
    }

    @GetMapping("/allocation/get/{id}")
    public ResponseEntity<Object> getAllocation(@PathVariable("id") Integer id){
        BookAllocationResponse bookAllocation = bookAllocationService.getBookAllocation(id);
        if(bookAllocation == null){
            throw new InvalidStudentInfoException();
        }
        return new ResponseEntity<>(bookAllocation, HttpStatus.FOUND);
    }

    @GetMapping("/list_students")
    public ResponseEntity<Iterable<Student>> getAllStudents(){
        return new ResponseEntity<>(studentService.getAllStudents(),HttpStatus.OK);
    }

    @GetMapping("/list_books")
    public ResponseEntity<Iterable<Book>> getAllBooks(){
        return new ResponseEntity<>(bookService.getAllBooks(),HttpStatus.OK);
    }

    @GetMapping("/list_librarians")
    public ResponseEntity<Iterable<Librarian>> getAllLibrarians(){
        return new ResponseEntity<>(librarianService.getAllLibrarians(),HttpStatus.OK);
    }
}
