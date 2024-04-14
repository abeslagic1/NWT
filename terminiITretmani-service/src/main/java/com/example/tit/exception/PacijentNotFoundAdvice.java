package com.example.tit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PacijentNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(PacijentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String pacijentNotFoundHandler(PacijentNotFoundException ex) {
        return ex.getMessage();
    }
    
}
