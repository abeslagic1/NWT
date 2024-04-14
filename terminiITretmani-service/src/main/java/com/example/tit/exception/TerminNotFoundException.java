package com.example.tit.exception;

public class TerminNotFoundException extends RuntimeException {

    public TerminNotFoundException(int id) {
        super("Nije moguće pronaći termin " + id);
    }
    
}
