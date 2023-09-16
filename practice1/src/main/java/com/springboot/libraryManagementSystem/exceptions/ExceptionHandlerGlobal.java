package com.springboot.libraryManagementSystem.exceptions;

import com.springboot.libraryManagementSystem.entities.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerGlobal {
    @ExceptionHandler(value = InvalidStudentInfoException.class)
    public ResponseEntity<Object> invalidStudentInfo(InvalidStudentInfoException invalidStudentInfoException){
        return new ResponseEntity<>(ErrorMessage.builder()
                .message("Invalid Request Info Exception: "+invalidStudentInfoException)
                .status(HttpStatus.BAD_REQUEST.toString())
                .timestamp(System.currentTimeMillis()).build(), HttpStatus.BAD_REQUEST);
    }
}
