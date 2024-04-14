package com.example.tit.model;

//import java.util.UUID;
import java.util.List;
import java.util.Objects;

//import org.hibernate.mapping.List;
//import org.hibernate.mapping.Set;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "Tretman")
public class Tretman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tID;
    
    @Column(name = "naziv")
    @NotBlank(message = "Naziv je obavezan")
    private String naziv;

    @Column(name = "opis")
    private String opis;

    @OneToOne(mappedBy = "tretman")
    private Doctor doktor;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tretman", cascade = CascadeType.ALL)
    private List<Termin> terminList;

    public Tretman() {
    }

    public Tretman(String naziv, String opis, Doctor doktor) {   
        this.naziv = naziv;
        this.opis = opis;
        this.doktor = doktor;
    }

    public int getID() {
        return tID;
    }
    public void setID(int termID) {
        this.tID = termID;
    }

    public String getNaziv() {
        return naziv;
    }
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }
    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Doctor getDoctor() {
        return doktor;
    }
    public void setDoctor(Doctor doktor) {
        this.doktor = doktor;
    }
    public List<Termin> getTerminList() {
        return terminList;
    }
    public void setTerminList(List<Termin> terminList) {
        this.terminList = terminList;
    }
  
    @Override
    public boolean equals(Object o) {

       if (this == o)
         return true;
       if (!(o instanceof Tretman))
         return false;
       Tretman tretman = (Tretman) o;
       return Objects.equals(this.tID, tretman.tID) && Objects.equals(this.naziv, tretman.naziv)
        && Objects.equals(this.opis, tretman.opis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.tID, this.naziv, this.opis);
    }

    @Override
    public String toString() {
        return "Tretman{" + "id = " + tID + ", naziv = " + naziv + ", opis= " + opis +"}";
    }


}
