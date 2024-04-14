package com.example.tit.exception;

public class TretmanNotFoundException extends RuntimeException { 

    public TretmanNotFoundException(int tID) {
        super("Nije moguće pronaći tretman " + tID);
    }
    
}
