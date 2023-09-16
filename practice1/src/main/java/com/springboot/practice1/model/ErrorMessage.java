package com.springboot.practice1.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorMessage {
    private String message;
    private String status;
    private long timestamp;
}
