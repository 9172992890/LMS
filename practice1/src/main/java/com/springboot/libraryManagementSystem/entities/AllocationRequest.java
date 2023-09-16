package com.springboot.libraryManagementSystem.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AllocationRequest {
    private Integer studentId;
    private  Integer bookId;
    private Integer librarianId;
}
