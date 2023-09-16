package com.springboot.practice1.Exceptions;

import com.springboot.practice1.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerGlobal {
    @ExceptionHandler(InvalidStudentInfoException.class)
    public ResponseEntity<Object> invalidStudentInfo(InvalidStudentInfoException invalidStudentInfoException){
        ErrorMessage errorMessage= ErrorMessage.builder()
                .message("Invalid Student Info Request")
                .status(HttpStatus.BAD_REQUEST.toString())
                .timestamp(System.currentTimeMillis())
                .build();
        return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
    }
}
