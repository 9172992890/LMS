package com.springboot.libraryManagementSystem.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Builder
@Entity(name="Book_Allocation_Details")
@AllArgsConstructor
@NoArgsConstructor
public class BookAllocation {
    @Id
    @Column(name = "Book_Allocation_Id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookAllocationId;

//    @Column(nullable = false, name = "Name")
//    private String name;

    @JoinColumn(name = "Student_ID", updatable = false, nullable = false)
    @JsonBackReference
    @ManyToOne(optional = false)
    private Student allocatedTo;

    @JoinColumn(name = "Book_ID", updatable = false, nullable = false)
    @JsonBackReference
    @ManyToOne(optional = false)
    private Book bookInfo;

    @JoinColumn(name = "Issued_By_Id", updatable = false, nullable = false)
    @JsonBackReference
    @ManyToOne(optional = false)
    private Librarian issuedBy;

    @Column(name = "Issued_On_Timestamp", updatable = false, nullable = false)
    private Long issuedOnTimestamp=System.currentTimeMillis();

    @Column(name = "Returned_Status", nullable = false)
    private boolean returnedStatus=false;

    @Column(name = "Returned_On")
    private Long returnedTimestamp=System.currentTimeMillis();
}
