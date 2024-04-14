package com.etf.model;

import jakarta.persistence.*;

@Entity
public class Krevet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@NotBlank(message = "The name of the bad must be entered!")
    private String nazivKreveta;

    //@NotBlank(message = "sobaId must be entered!")
    private Integer sobaId;

    private Boolean zauzetost;

    public Krevet() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazivKreveta() {
        return nazivKreveta;
    }

    public void setNazivKreveta(String nazivKreveta) {
        this.nazivKreveta = nazivKreveta;
    }

    public Integer getSobaId() {
        return sobaId;
    }

    public void setSobaId(Integer sobaId) {
        this.sobaId = sobaId;
    }

    public Boolean getZauzetost() {
        return zauzetost;
    }

    public void setZauzetost(Boolean zauzetost) {
        this.zauzetost = zauzetost;
    }
}
