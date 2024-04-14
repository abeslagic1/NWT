package com.example.tit.exception;

public class TerminZauzetostiNotFoundException extends RuntimeException {

    public TerminZauzetostiNotFoundException(int tzID) {
        super("Nije moguće pronaći termin zauzetosti " + tzID);
    }
    
}
