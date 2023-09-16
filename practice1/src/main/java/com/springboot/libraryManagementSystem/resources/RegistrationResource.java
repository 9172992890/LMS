package com.springboot.libraryManagementSystem.resources;

import com.springboot.libraryManagementSystem.entities.Book;
import com.springboot.libraryManagementSystem.entities.Librarian;
import com.springboot.libraryManagementSystem.entities.Student;
import com.springboot.libraryManagementSystem.exceptions.InvalidStudentInfoException;
import com.springboot.libraryManagementSystem.services.BookService;
import com.springboot.libraryManagementSystem.services.LibrarianService;
import com.springboot.libraryManagementSystem.services.StudentService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("library/register")
public class RegistrationResource {
    @Autowired
    StudentService studentService;
    @Autowired
    LibrarianService librarianService;

    @Autowired
    BookService bookService;
    @PostMapping("/student")
    public ResponseEntity<Object> addStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.CREATED);
    }

    @PostMapping("/librarian")
    public ResponseEntity<Object> addLibrarian(@RequestBody Librarian librarian) {
        return new ResponseEntity<>(librarianService.addLibrarian(librarian), HttpStatus.CREATED);
    }

    @PostMapping("/book")
    public ResponseEntity<Object> addBook(@RequestBody Book book){
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.CREATED);
    }
    @PostMapping("/bulk_student_import")
    public ResponseEntity<Iterable<Student>> bulkStudentImport(@RequestBody List<Student> ls){
        return new ResponseEntity<>(studentService.bulkStudentImport(ls),HttpStatus.CREATED);
    }
    @PostMapping("/bulk_book_import")
    public ResponseEntity<Iterable<Book>> bulkBookImport(@RequestBody List<Book> ls){
        return new ResponseEntity<>(bookService.bulkBookImport(ls),HttpStatus.CREATED);
    }

    @PostMapping("/bulk_librarian_import")
    public ResponseEntity<Iterable<Librarian>> bulkLibrarianImport(@RequestBody List<Librarian> ls){
        return new ResponseEntity<>(librarianService.bulkLibrarianImport(ls),HttpStatus.CREATED);
    }

    @PostMapping("/parse_csv")
    public ResponseEntity<Iterable<Book>> parseCSV(HttpServletRequest httpServletRequest) throws ServletException, IOException{
        Part textPart= httpServletRequest.getPart("Organisation");
        Part filePart=httpServletRequest.getPart("book_csv");

        InputStream textInputStream= textPart.getInputStream();
        IOUtils.toString(textInputStream, StandardCharsets.UTF_8);

        InputStream fileInputStream=filePart.getInputStream();
        CSVFormat csvFormat=CSVFormat.DEFAULT;

        CSVParser csvParser=new CSVParser(new InputStreamReader(fileInputStream),csvFormat);

        List<CSVRecord> records=csvParser.getRecords().stream().skip(1).collect(Collectors.toList());

        List<Book> list_book =new ArrayList<>();

        for(CSVRecord record:records){
            String name=record.get(0);
            String author=record.get(1);

            if(name!=null && author!=null){
                list_book.add(Book.builder()
                        .name(name)
                        .author(author).build());
            }
            else {
                throw new InvalidStudentInfoException();
            }
        }

        return new ResponseEntity<>(bookService.addBookList(list_book),HttpStatus.CREATED);
    }

//Below code have some error
//    @PostMapping("/dynamic/{type}")
//    public ResponseEntity<Object> register(@RequestBody Object obj, @PathVariable("type") String type){
//        switch (type){
//            case "student":
//                return new ResponseEntity<>(studentService.addStudent((Student)obj), HttpStatus.CREATED);
//            case "librarian":
//                return new ResponseEntity<>(librarianService.addLibrarian((Librarian)obj), HttpStatus.CREATED);
//            case "book":
//                return new ResponseEntity<>(bookService.addBook((Book)obj), HttpStatus.CREATED);
//            default:
//                return new ResponseEntity<>("Invalid URL: ", HttpStatus.CREATED);
//        }
//    }
}
