package com.etf.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;


import java.util.List;

@Entity
public class Soba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@NotBlank(message = "Room name must be entered.")
    private String nazivSobe;

    private Boolean zauzetost;

    //@NotBlank(message = "You need to chose private or shared room")
    private String privateShared;

    public Soba() {
    }

    public Soba(String nazivSobe, String privateShared) {
        this.nazivSobe = nazivSobe;
        this.privateShared = privateShared;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazivSobe() {
        return nazivSobe;
    }

    public void setNazivSobe(String nazivSobe) {
        this.nazivSobe = nazivSobe;
    }

    public Boolean getZauzetost() {
        return zauzetost;
    }

    public void setZauzetost(Boolean zauzetost) {
        this.zauzetost = zauzetost;
    }

    public String getPrivateShared() {
        return privateShared;
    }

    public void setPrivateShared(String privateShared) {
        this.privateShared = privateShared;
    }
}
