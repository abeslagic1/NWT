package com.example.tit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DoctorNotFoundException extends RuntimeException {

    public DoctorNotFoundException(int docID) {
        super("Nije moguće pronaći doktora " + docID);
    }   
}
