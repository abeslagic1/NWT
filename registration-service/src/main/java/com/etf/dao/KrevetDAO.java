package com.etf.dao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class KrevetDAO {

    @NotBlank(message = "The name of the bad must be entered!")
    @NotNull(message = "The name of the bad must be entered!")
    private String nazivKreveta;

    //@NotBlank(message = "sobaId must be entered!")
    private Integer sobaId;

    private Boolean zauzetost;


    public KrevetDAO() {
    }

    public KrevetDAO(String nazivKreveta, Integer sobaId) {
        this.nazivKreveta = nazivKreveta;
        this.sobaId = sobaId;
    }

    public KrevetDAO(String nazivKreveta, Integer sobaId, Boolean zauzetost) {
        this.nazivKreveta = nazivKreveta;
        this.sobaId = sobaId;
        this.zauzetost = zauzetost;
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
