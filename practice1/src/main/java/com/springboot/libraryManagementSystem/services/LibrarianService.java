package com.springboot.libraryManagementSystem.services;

import com.springboot.libraryManagementSystem.entities.Book;
import com.springboot.libraryManagementSystem.entities.Librarian;
import com.springboot.libraryManagementSystem.repositories.LibrarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibrarianService {
    @Autowired
    LibrarianRepository librarianRepository;

    public Librarian addLibrarian(Librarian librarian){
        return librarianRepository.save(librarian);
    }

    public Iterable<Librarian> getAllLibrarians() {
        return librarianRepository.findAll();
    }

    public Iterable<Librarian> bulkLibrarianImport(List<Librarian> librarians) {
        librarianRepository.saveAll(librarians);
        return librarianRepository.findAll();
    }
}
