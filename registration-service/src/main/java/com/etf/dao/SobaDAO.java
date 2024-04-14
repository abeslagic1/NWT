package com.etf.dao;

import jakarta.validation.constraints.NotBlank;

public class SobaDAO {


    @NotBlank(message = "Room name must be entered.")
    private String nazivSobe;

    private Boolean zauzetost;

    @NotBlank(message = "You need to chose private or shared room")
    private String privateShared;


    public SobaDAO() {
    }

    public SobaDAO(String nazivSobe, Boolean zauzetost, String privateShared) {
        this.nazivSobe = nazivSobe;
        this.zauzetost = zauzetost;
        this.privateShared = privateShared;
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
