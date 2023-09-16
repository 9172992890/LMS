package com.springboot.libraryManagementSystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name="Librarian_Details")
public class Librarian {
    @Id
    @Column(name = "Librarian_ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer librarianId;

    @Column(nullable = false, name = "Name")
    private String name;

    private int age;

    @Column(nullable = false)
    private String contact;

    @OneToMany(mappedBy = "issuedBy",cascade = CascadeType.ALL)
    @JsonIgnore
    @JsonManagedReference
    private List<BookAllocation> allocatedList;
}
