package com.example.tit.exception;

public class PacijentNotFoundException extends RuntimeException { 

    public PacijentNotFoundException(int pacID) {
        super("Nije moguće pronaći pacijenta " + pacID);
    }
    
}
