package com.example.tit.model;

//import java.util.UUID;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.*;

@Entity
@Table(name = "Pacijent")
public class Pacijent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pacID;

    @Column(name = "ime")
    @NotBlank(message = "Ime je obavezno")
    private String ime;

    @Column(name = "prezime")
    @NotBlank(message = "Prezime je obavezno")
    private String prezime;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "termin_pacijent", joinColumns = @JoinColumn(name = "pacijent_id"), inverseJoinColumns = @JoinColumn(name = "termin_id"))
    private List<Termin> terminList;

    public Pacijent() {
    }

    public Pacijent(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
    }

    public int getID() {
        return pacID;
    }
    public void setID(int pacID) {
        this.pacID = pacID;
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
        if (!(o instanceof Pacijent))
          return false;
        Pacijent pacijent = (Pacijent) o;
        return Objects.equals(this.pacID, pacijent.pacID) && Objects.equals(this.ime, pacijent.ime) && Objects.equals(this.prezime, pacijent.prezime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.pacID, this.ime, this.prezime);
    }

    @Override
    public String toString() {
        return "Pacijent{id=" + pacID + ", ime = " + ime + ", prezime = "+ prezime + "}";
    }


}
