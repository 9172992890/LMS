package com.springboot.libraryManagementSystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@Entity(name="Book_Details")
public class Book {
    @Id
    @Column(name = "Book_ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String author;

    private int availableCopies=1;

    @OneToMany(mappedBy = "bookInfo", cascade = CascadeType.ALL)
    @JsonIgnore
    @JsonManagedReference
    private List<BookAllocation> allocatedTo;

}
