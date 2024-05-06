package com.example.tit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestStatusException extends RuntimeException{
    
    public BadRequestStatusException(String message){
        super(message);
    }
}
