package com.example.tit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TerminZauzetostiNotFoundException extends RuntimeException {

    public TerminZauzetostiNotFoundException(int tzID) {
        super("Nije moguće pronaći termin zauzetosti " + tzID);
    }
    
}
