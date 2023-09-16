package com.springboot.libraryManagementSystem.services;

import com.springboot.libraryManagementSystem.entities.Book;
import com.springboot.libraryManagementSystem.entities.Student;
import com.springboot.libraryManagementSystem.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Iterable<Book> bulkBookImport(List<Book> books) {
        bookRepository.saveAll(books);
        return bookRepository.findAll();
    }

    public Iterable<Book> addBookList(List<Book> listBook) {
        return bookRepository.saveAll(listBook);
    }
}
