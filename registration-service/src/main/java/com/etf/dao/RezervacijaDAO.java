package com.etf.dao;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class RezervacijaDAO {

    //@NotBlank(message = "PacijentId must be entered.")
    @NotNull(message = "PacijentId must be entered.")
    private Integer pacijentId;

    @NotNull(message = "SobaId must be entered.")
    private Integer sobaId;

    @NotNull(message = "KrevetId must be entered.")
    private Integer krevetId;

    @NotNull(message = "datumDolaska must be entered.")
    @FutureOrPresent
    private Date datumDolaska;

    @NotNull(message = "datumOdlaska must be entered.")
    @Future
    private Date datumOdlaska;

    public RezervacijaDAO() {
    }

    public RezervacijaDAO(Integer pacijentId, Integer sobaId, Integer krevetId, Date datumDolaska, Date datumOdlaska) {
        this.pacijentId = pacijentId;
        this.sobaId = sobaId;
        this.krevetId = krevetId;
        this.datumDolaska = datumDolaska;
        this.datumOdlaska = datumOdlaska;
    }

    public Integer getPacijentId() {
        return pacijentId;
    }

    public void setPacijentId(Integer pacijentId) {
        this.pacijentId = pacijentId;
    }

    public Integer getSobaId() {
        return sobaId;
    }

    public void setSobaId(Integer sobaId) {
        this.sobaId = sobaId;
    }

    public Integer getKrevetId() {
        return krevetId;
    }

    public void setKrevetId(Integer krevetId) {
        this.krevetId = krevetId;
    }

    public Date getDatumDolaska() {
        return datumDolaska;
    }

    public void setDatumDolaska(Date datumDolaska) {
        this.datumDolaska = datumDolaska;
    }

    public Date getDatumOdlaska() {
        return datumOdlaska;
    }

    public void setDatumOdlaska(Date datumOdlaska) {
        this.datumOdlaska = datumOdlaska;
    }
}
