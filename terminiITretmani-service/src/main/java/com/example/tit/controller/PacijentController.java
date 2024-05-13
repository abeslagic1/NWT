package com.example.tit.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.apache.hc.core5.http.HttpStatus;
//import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;

import com.example.tit.dao.PacijentRepository;
import com.example.tit.model.Pacijent;

import jakarta.validation.Valid;

import com.example.tit.exception.DoctorNotFoundException;
//import com.example.tit.exception.NotFoundException;
import com.example.tit.exception.PacijentNotFoundException;

@Validated
@RestController
@RequestMapping(path = "/tit/pacijenti")
public class PacijentController {
    
    @Autowired
    private final PacijentRepository pacijentRepository;

    PacijentController(PacijentRepository pacijentRepository) {
        this.pacijentRepository = pacijentRepository;
    }

    @GetMapping()
    Iterable<Pacijent> all() {
        return pacijentRepository.findAll();
    }

    // @GetMapping("/{ime}")
    // public @ResponseBody ResponseEntity<?> getPacijenetName(@PathVariable("ime") String ime) {

    //     try{
    //         Pacijent pacijent = pacijentRepository.findByIme(ime);

    //         if(pacijent == null) throw new NotFoundException("Pacijent nije pronađen.");

    //         return ResponseEntity.ok(pacijent);
    //     }catch (NotFoundException e) {
    //         return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    //     }  
    // }

    // @GetMapping("/{prezime}")
    // public @ResponseBody ResponseEntity<?> getPacijenetSurname(@PathVariable("prezime") String prezime) {

    //     try{
    //         Pacijent pacijent = pacijentRepository.findByPrezime(prezime);

    //         if(pacijent == null) throw new NotFoundException("Pacijent nije pronađen.");

    //         return ResponseEntity.ok(pacijent);
    //     }catch (NotFoundException e) {
    //         return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    //     }  
    // }


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

    @PatchMapping("/{pacID}")
    Pacijent updatePacijent(@PathVariable int pacID, @RequestBody Pacijent updatedPacijent) {
        return pacijentRepository.findById(pacID).map(pacijent -> {
            if (updatedPacijent.getIme() != null) {
                pacijent.setIme(updatedPacijent.getIme());
            }
            if (updatedPacijent.getPrezime() != null) {
                pacijent.setPrezime(updatedPacijent.getPrezime());
            }
            return pacijentRepository.save(pacijent);
        }).orElseThrow(() -> new DoctorNotFoundException(pacID));
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
