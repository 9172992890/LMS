package com.springboot.libraryManagementSystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name="Student_Details")
public class Student {
    @Id
    @Column(name = "Student_ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentId;

    @Column(nullable = false, name = "Name")
    private String name;

    private int age;

    @Column(nullable = false)
    private String contact;

    private String branch;

    private String accountStatus="Active";

    private long registrationTimeStamp= System.currentTimeMillis();

    @Column(nullable = false)
    private long updateTimestamp=System.currentTimeMillis();

    @OneToMany(mappedBy = "allocatedTo", cascade =CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnore
    private List<BookAllocation> allocatedBooks;
}