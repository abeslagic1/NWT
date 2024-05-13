package com.example.tit.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;

//import java.sql.Date;

//import org.hibernate.mapping.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tit.dao.TerminZauzetostiRepository;
import com.example.tit.model.TerminZauzetosti;

import jakarta.validation.Valid;

import com.example.tit.exception.TerminZauzetostiNotFoundException;

@Validated
@RestController
@RequestMapping(path = "/tit/terminiZauzetosti")
public class TerminZauzetostiController {

    private final TerminZauzetostiRepository terminZauzetostiRepository;

    TerminZauzetostiController(TerminZauzetostiRepository terminZauzetostiRepository) {
        this.terminZauzetostiRepository = terminZauzetostiRepository;
    }

    @GetMapping()
    Iterable<TerminZauzetosti> all() {
        return terminZauzetostiRepository.findAll();
    }

    @PostMapping()
    TerminZauzetosti terminZauzetosti(@Valid @RequestBody TerminZauzetosti newTerminZauzetosti) {
        return terminZauzetostiRepository.save(newTerminZauzetosti);
    }

    @GetMapping("/{tzID}")
    TerminZauzetosti one(@PathVariable int tzID) {
        return terminZauzetostiRepository.findById(tzID).orElseThrow(() -> new TerminZauzetostiNotFoundException(tzID));
    }

    @PutMapping("/{tzID}")
    TerminZauzetosti replaceTerminZauzetosti(@RequestBody TerminZauzetosti newTerminZauzetosti, @PathVariable int tzID) {
        return terminZauzetostiRepository.findById(tzID).map(terminZauzetosti -> {
            terminZauzetosti.setDatumTretmana(newTerminZauzetosti.getDatumTretmana());
            terminZauzetosti.setVrijemePocetka(newTerminZauzetosti.getVrijemePocetka());
            terminZauzetosti.setVrijemeKraja(newTerminZauzetosti.getVrijemeKraja());
            return terminZauzetostiRepository.save(terminZauzetosti);
        })
        .orElseGet(() -> {
            newTerminZauzetosti.setID(tzID);
            return terminZauzetostiRepository.save(newTerminZauzetosti);
        });
    }

    @DeleteMapping("/{tzID}")
    void deleteTerminZauzetosti(@PathVariable int tzID) {
        terminZauzetostiRepository.deleteById(tzID);
    }



    //@PostMapping(path = "/addTerminZauzetosti")
    //public @ResponseBody String addNewTerminZauzetosti(@RequestParam Date datumTretmana, @RequestParam Date vrijemePocetka, @RequestParam Date vrijemeKraja) {
      //  TerminZauzetosti terminZauzetosti = new TerminZauzetosti();
        //terminZauzetosti.setDatumTretmana(datumTretmana);
        //terminZauzetosti.setVrijemePocetka(vrijemePocetka);
        //terminZauzetosti.setVrijemeKraja(vrijemeKraja);
        //terminZauzetostiRepository.save(terminZauzetosti);
        //return "Saved";
    //}

    //@GetMapping(path = "/allTerminZauzetosti")
    //public @ResponseBody Iterable<TerminZauzetosti> getAllTerminZauzetosti() {
      //  return terminZauzetostiRepository.findAll();
    //}    
}
