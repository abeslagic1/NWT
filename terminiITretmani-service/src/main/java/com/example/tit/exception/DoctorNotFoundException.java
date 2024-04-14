package com.example.tit.exception;

public class DoctorNotFoundException extends RuntimeException {

    public DoctorNotFoundException(int docID) {
        super("Nije moguće pronaći doktora " + docID);
    }   
}
