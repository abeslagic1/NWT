package com.example.tit.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;

@Entity
@Table(name = "Termin")
public class Termin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "status")
    private String status;

    @Column(name = "komentar")
    private String komentar;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "termin", cascade = CascadeType.ALL)
    private List<TerminZauzetosti> terminiZauzetosti;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tretman_id")
    private Tretman tretman;

    @OneToOne(mappedBy = "termin")
    private Doctor doctor;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "termin_pacijent", joinColumns = @JoinColumn(name = "termin_id"), inverseJoinColumns = @JoinColumn(name = "pacijent_id"))
    private List<Pacijent> pacijenti;

    public Termin() {
    }

    public Termin(String status, String komentar, List<TerminZauzetosti> terminiZauzetosti, Tretman tretman, Doctor doctor, List<Pacijent> pacijenti) {
        this.status = status;
        this.komentar = komentar;
        this.terminiZauzetosti = terminiZauzetosti;
        this.tretman = tretman;
        this.doctor = doctor;
        this.pacijenti = pacijenti;
    }

    public int getID() {
        return id;
    }
    public void setID(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getKomentar() {
        return komentar;
    }
    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public List<TerminZauzetosti> getTerminZ() {
        return terminiZauzetosti;
    }
    public void setTerminZ(List<TerminZauzetosti> terminiZauzetosti) {
        this.terminiZauzetosti = terminiZauzetosti;
    }
     
    public Tretman getTretman() {
        return tretman;
    }
    public void setTretman(Tretman tretman) {
        this.tretman = tretman;
    }
    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    } 
    public List<Pacijent> getPacijent() {
        return pacijenti;
    }
    public void setPacijent(List<Pacijent> pacijenti) {
        this.pacijenti = pacijenti;
    }

    @Override
    public boolean equals(Object o) {

       if (this == o)
         return true;
       if (!(o instanceof Termin))
         return false;
       Termin termin = (Termin) o;
       return Objects.equals(this.id, termin.id) && Objects.equals(this.komentar, termin.komentar)
        && Objects.equals(this.status, termin.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.komentar, this.status);
    }
    @Override
    public String toString() {
        return "Termin [id = " + id + ", status = " + status + ", komentar = " + komentar + "]";
    }


}
