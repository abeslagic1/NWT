package com.etf.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.web.client.HttpClientErrorException;

import java.util.UUID;


@Entity
public class Pacijent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //    @NotBlank(message = "First name must be entered.")
//    @Size(min = 3, max = 50, message = "Length mus be at least 3 chars long.")
    private String ime;

    //    @NotBlank(message = "Last name must be entered.")
//    @Size(min = 3, max = 50, message = "Length mus be at least 3 chars long.")
    private String prezime;
    private Boolean samUSobi;



    public Pacijent() {
    }

    public Pacijent(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
    }

    public Pacijent(String ime, String prezime, Boolean samUSobi) {
        this.ime = ime;
        this.prezime = prezime;
        this.samUSobi = samUSobi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Pacijent{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", samUSobi=" + samUSobi +
                '}';
    }
}