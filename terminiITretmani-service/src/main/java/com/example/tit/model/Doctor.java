package com.example.tit.model;

//import java.util.UUID;

//import jakarta.annotation.Generated;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

import jakarta.persistence.*;


@Entity
@Table(name = "Doktor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int docID;

    @Column(name = "ime")
    @NotBlank(message = "Ime je obavezno")
    private String name;

    @Column(name = "prezime")
    @NotBlank(message = "Prezime je obavezno")
    private String surrname;

    @Column(name = "specijalizacija")
    @NotBlank(message = "Specijalizacija je obavezna")
    private String specialization;

    @OneToOne
    @JoinColumn(name = "termin_id")
    private Termin termin;

    @OneToOne
    @JoinColumn(name = "tretman_id")
    private Tretman tretman;

    public Doctor() {
    }

    public Doctor(String name, String surrname, String specialization) {
        this.name = name;
        this.surrname = surrname;
        this.specialization = specialization;
    }

    public int getID() {
        return docID;
    }
    public void setID(int docID) {
        this.docID = docID;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurrname() {
        return surrname;
    }
    public void setSurrname(String surrname) {
        this.surrname = surrname;
    }

    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
          return true;
        if (!(o instanceof Doctor))
          return false;
        Doctor doktor = (Doctor) o;
        return Objects.equals(this.docID, doktor.docID) && Objects.equals(this.name, doktor.name) && Objects.equals(this.surrname, doktor.surrname) && Objects.equals(this.specialization, doktor.specialization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.docID, this.name, this.surrname, this.specialization);
    }

    @Override
    public String toString() {
        return "Doktor{" + "id = " + docID + ", ime = " + name + ", prezime = " + surrname + ", specijalizacija = " + specialization + "}";
    }

}
