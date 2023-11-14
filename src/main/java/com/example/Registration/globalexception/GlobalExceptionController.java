package com.example.Registration.globalexception;

import com.example.Registration.customException.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUsernotFoundException(){
        Map<String,Object> body = new LinkedHashMap<>();
        body.put("Exception","User Not Found");


        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
