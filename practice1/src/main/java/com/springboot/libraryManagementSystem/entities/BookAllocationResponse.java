package com.springboot.libraryManagementSystem.entities;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BookAllocationResponse {

    private Integer bookAllocationId;

    private Student allocatedTo;

    private Book bookInfo;

    private String issuedBy;

    private Long issuedOnTimestamp;

    private boolean returnedStatus;

    private Long returnedTimestamp;

}
