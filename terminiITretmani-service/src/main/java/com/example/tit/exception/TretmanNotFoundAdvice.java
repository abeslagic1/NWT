package com.example.tit.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TretmanNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(TretmanNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String tretmanNotFoundHandler(TretmanNotFoundException ex) {
        return ex.getMessage();
    }
    
}
