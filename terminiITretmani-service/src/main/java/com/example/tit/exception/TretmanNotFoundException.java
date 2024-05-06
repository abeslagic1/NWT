package com.example.tit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TretmanNotFoundException extends RuntimeException { 

    public TretmanNotFoundException(int tID) {
        super("Nije moguće pronaći tretman " + tID);
    }
    
}
