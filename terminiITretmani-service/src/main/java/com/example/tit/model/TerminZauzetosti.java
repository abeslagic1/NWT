package com.example.tit.model;

import java.sql.Date;
//import java.util.UUID;
import java.util.Objects;

import jakarta.persistence.*;
//import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Termin_Zauzetosti")
public class TerminZauzetosti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tzID;
    
    @Column(name = "datum_tretmana")
    @NotNull(message = "Datum tretmana je obavezan")
    private Date datumTretmana;

    @Column(name = "vrijeme_pocetka")
    @NotNull(message = "Vrijeme početka je obavezno")
    private Date vrijemePocetka;

    @Column(name = "vrijeme_kraja")
    @NotNull(message = "Vrijeme kraja je obavezno")
    private Date vrijemeKraja;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "termin_id")
    private Termin termin;

    public TerminZauzetosti() {
    }

    public TerminZauzetosti(Date datumTretmana, Date vrijemePocetka, Date vrijemeKraja) {
        
        this.datumTretmana = datumTretmana;
        this.vrijemePocetka = vrijemePocetka;
        this.vrijemeKraja = vrijemeKraja;
    }

    public int getID() {
        return tzID;
    }
    public void setID(int tzID) {
        this.tzID = tzID;
    }

    public Date getDatumTretmana() {
        return datumTretmana;
    }
    public void setDatumTretmana(Date datumTretmana) {
        this.datumTretmana = datumTretmana;
    }

    public Date getVrijemePocetka() {
        return vrijemePocetka;
    }
    public void setVrijemePocetka(Date vrijemePocetka) {
        this.vrijemePocetka = vrijemePocetka;
    }

    public Date getVrijemeKraja() {
        return vrijemeKraja;
    }
    public void setVrijemeKraja(Date vrijemeKraja) {
        this.vrijemeKraja = vrijemeKraja;
    }
     public Termin getTermin() {
        return termin;
    }
    public void setTermin(Termin termin) {
        this.termin = termin;
    }

    @Override
    public boolean equals(Object o) {

       if (this == o)
         return true;
       if (!(o instanceof TerminZauzetosti))
         return false;
       TerminZauzetosti terminZauzetosti = (TerminZauzetosti) o;
       return Objects.equals(this.tzID, terminZauzetosti.tzID) && Objects.equals(this.datumTretmana, terminZauzetosti.datumTretmana)
        && Objects.equals(this.vrijemePocetka, terminZauzetosti.vrijemePocetka) && Objects.equals(this.vrijemeKraja, terminZauzetosti.vrijemeKraja);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.tzID, this.datumTretmana, this.vrijemePocetka, this.vrijemeKraja);
    }
    
    @Override
    public String toString() {
        return "Termin zauzetosti{" + "id = " + tzID + ", datum tretmana = " + datumTretmana + ", vrijeme pocetka = " + vrijemePocetka + ", vrijemeKraja = " + vrijemeKraja + "}";
    }
}
