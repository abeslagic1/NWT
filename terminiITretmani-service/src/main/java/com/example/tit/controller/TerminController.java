package com.example.tit.controller;

import org.springframework.validation.annotation.Validated;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tit.dao.TerminRepository;
import com.example.tit.model.Termin;
//import com.fasterxml.jackson.databind.JsonNode;
import com.example.tit.exception.TerminNotFoundException;

@Validated
@RestController
@RequestMapping(path = "/tit/termini")
public class TerminController {

    private final TerminRepository terminRepository;

    TerminController(TerminRepository terminRepository) {
        this.terminRepository = terminRepository;
    }

    @GetMapping()
    Iterable<Termin> all() {
        return terminRepository.findAll();
    }
    
    @PostMapping()
    Termin newTermin(@RequestBody Termin newTermin) {
        return terminRepository.save(newTermin);
    }

    @GetMapping("/{id}")
    Termin one(@PathVariable int id) {
        return terminRepository.findById(id).orElseThrow(() -> new TerminNotFoundException(id));
    }

    @PostMapping("/{id}")
    Termin replaceTermin(@RequestBody Termin newTermin, @PathVariable int id) {
        return terminRepository.findById(id).map(termin -> {
            termin.setKomentar(newTermin.getKomentar());
            termin.setStatus(newTermin.getStatus());
            return terminRepository.save(termin);
        }).orElseGet(() -> {
            newTermin.setID(id);
            return terminRepository.save(newTermin);
        });
    }

    @DeleteMapping("/{id}")
    void deleteTermin(@PathVariable int id) {
        terminRepository.deleteById(id);
    }


    @PatchMapping("/{id}")
    Termin updateTermin(@PathVariable int id, @RequestBody Termin updatedTermin) {
        return terminRepository.findById(id).map(termin -> {
            if (updatedTermin.getKomentar() != null) {
                termin.setKomentar(updatedTermin.getKomentar());
            }
            if (updatedTermin.getStatus() != null) {
                termin.setStatus(updatedTermin.getStatus());
            }
            return terminRepository.save(termin);
        }).orElseThrow(() -> new TerminNotFoundException(id));
    }


    //@PostMapping(path = "/addTermin")
    //public @ResponseBody String addNewTermin(@RequestBody String status, @RequestBody String komentar ) {
      //  Termin termin = new Termin();
       // termin.setStatus(status);
        //termin.setKomentar(komentar);
        //terminRepository.save(termin);
        //return "Saved";
    //}    

    //@GetMapping(path = "/allTermin")
    //public @ResponseBody Iterable<Termin> getAllTermin() {
      //  return terminRepository.findAll();
    //}
}
