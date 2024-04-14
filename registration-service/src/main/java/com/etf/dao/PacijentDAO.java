package com.etf.dao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PacijentDAO {

    @NotBlank(message = "First name must be entered.")
    @Size(min = 3, max = 50, message = "Length must be at least 3 chars long.")
    private String ime;

    @NotBlank(message = "Last name must be entered.")
    @Size(min = 3, max = 50, message = "Length must be at least 3 chars long.")
    private String prezime;

    private Boolean samUSobi;

    public PacijentDAO() {
    }

    public PacijentDAO(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
    }

    public PacijentDAO(String ime, String prezime, Boolean samUSobi) {
        this.ime = ime;
        this.prezime = prezime;
        this.samUSobi = samUSobi;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Boolean getSamUSobi() {
        return samUSobi;
    }

    public void setSamUSobi(Boolean samUSobi) {
        this.samUSobi = samUSobi;
    }
}
