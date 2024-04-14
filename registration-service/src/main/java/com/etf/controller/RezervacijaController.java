package com.etf.controller;

import com.etf.dao.RezervacijaDAO;
import com.etf.model.Rezervacija;
import com.etf.repository.RezervacijaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Validated
@RestController
@RequestMapping(path = "/Rezervacija")
public class RezervacijaController {

    @Autowired
    private RezervacijaRepository rezervacijaRepository;

    @PostMapping(path = "/")
    ResponseEntity <String> addNewRezervacija(@RequestBody @Valid RezervacijaDAO rezervacijaDAO){

        Rezervacija r = new Rezervacija();

        r.setPacijentId(rezervacijaDAO.getPacijentId());
        r.setSobaId(rezervacijaDAO.getSobaId());
        r.setKrevetId(rezervacijaDAO.getKrevetId());
        r.setDatumDolaska(rezervacijaDAO.getDatumDolaska());
        r.setDatumOdlaska(rezervacijaDAO.getDatumDolaska());

        rezervacijaRepository.save(r);

        return ResponseEntity.ok("Reservation has been added.");
    }

    @GetMapping(path = "/")
    public @ResponseBody Iterable<Rezervacija> getAllRezervacije() {

        return rezervacijaRepository.findAll();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)

    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}