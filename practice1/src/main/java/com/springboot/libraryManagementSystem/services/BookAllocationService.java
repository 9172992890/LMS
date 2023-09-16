package com.springboot.libraryManagementSystem.services;

import com.springboot.libraryManagementSystem.entities.*;

import com.springboot.libraryManagementSystem.repositories.BookAllocationRepository;
import com.springboot.libraryManagementSystem.repositories.BookRepository;
import com.springboot.libraryManagementSystem.repositories.LibrarianRepository;
import com.springboot.libraryManagementSystem.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookAllocationService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    LibrarianRepository librarianRepository;
    @Autowired
    BookAllocationRepository bookAllocationRepository;

    public BookAllocation addBookAllocationDetails(AllocationRequest allocationRequest){
        Optional<Student> student=studentRepository.findById(allocationRequest.getStudentId());
        Optional<Book> book= bookRepository.findById(allocationRequest.getBookId());
        Optional<Librarian> librarian=librarianRepository.findById(allocationRequest.getLibrarianId());

        if(student.isPresent() && book.isPresent() && librarian.isPresent()){
            return bookAllocationRepository.save(BookAllocation.builder()
                    .allocatedTo(student.get())
                    .bookInfo(book.get())
                    .issuedBy(librarian.get())
                    .issuedOnTimestamp(System.currentTimeMillis()).build());
        }else {
            return null;
        }
    }

    public BookAllocationResponse getBookAllocation(Integer id){
        BookAllocation allocation =bookAllocationRepository.findById(id).orElse(null);
        return BookAllocationResponse.builder()
                .bookAllocationId(allocation.getBookAllocationId())
                .allocatedTo(allocation.getAllocatedTo())
                .bookInfo(allocation.getBookInfo())
                .returnedStatus(allocation.isReturnedStatus())
                .issuedBy(allocation.getIssuedBy().getName())
                .issuedOnTimestamp(allocation.getIssuedOnTimestamp()).build();
    }
}
