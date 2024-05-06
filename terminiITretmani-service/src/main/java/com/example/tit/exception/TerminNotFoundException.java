package com.example.tit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TerminNotFoundException extends RuntimeException {

    public TerminNotFoundException(int id) {
        super("Nije moguće pronaći termin " + id);
    }
    
}
