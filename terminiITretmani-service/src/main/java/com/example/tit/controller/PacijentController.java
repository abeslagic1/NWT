package com.example.tit.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tit.dao.PacijentRepository;
import com.example.tit.model.Pacijent;

import jakarta.validation.Valid;

import com.example.tit.exception.PacijentNotFoundException;

@RestController
@RequestMapping(path = "/pacijenti")
public class PacijentController {
    
    private final PacijentRepository pacijentRepository;

    PacijentController(PacijentRepository pacijentRepository) {
        this.pacijentRepository = pacijentRepository;
    }

    @GetMapping()
    Iterable<Pacijent> all() {
        return pacijentRepository.findAll();
    }

    @PostMapping()
    Pacijent newPacijent(@Valid @RequestBody Pacijent newPacijent) {
        return pacijentRepository.save(newPacijent);
    }

    @GetMapping("/{pacID}")
    Pacijent one(@PathVariable int pacID) {
        return pacijentRepository.findById(pacID).orElseThrow(() -> new PacijentNotFoundException(pacID));
    }

    @PutMapping("/{pacID}")
    Pacijent replacePacijent(@RequestBody Pacijent newPacijent, @PathVariable int pacID) {
        return pacijentRepository.findById(pacID).map(pacijent -> {
            pacijent.setIme(newPacijent.getIme());
            pacijent.setPrezime((newPacijent.getPrezime()));
            return pacijentRepository.save(pacijent);
        })
        .orElseGet(() -> {
            newPacijent.setID(pacID);
            return pacijentRepository.save(newPacijent);
        });
    }

    @DeleteMapping("/{pacID}")
    void deletePacijent(@PathVariable int pacID) {
        pacijentRepository.deleteById(pacID);
    }

    //@PostMapping(path = "/addPacijent")
    //public @ResponseBody String addNewPacijent(@RequestBody String ime, @RequestBody String prezime) {
      //  Pacijent pacijent = new Pacijent();
       // pacijent.setIme(ime);
        //pacijent.setPrezime(prezime);
        //pacijentRepository.save(pacijent);
        //return "Saved";
    //}
     
    //@GetMapping(path = "/allPacijent")
    //public @ResponseBody Iterable<Pacijent> getAllPacijenti() {
      //  return pacijentRepository.findAll();
    //}
    
}
