package com.etf.controller;

import com.etf.dao.KrevetDAO;
import com.etf.exceptions.NotFoundException;
import com.etf.model.Krevet;
import com.etf.model.Pacijent;
import com.etf.repository.KrevetRepository;

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
import java.util.Optional;


@Validated
@RestController
@RequestMapping(path = "/Rezervation/Krevet")
public class KrevetController {

    @Autowired
    private KrevetRepository krevetRepository;

    @PostMapping(path = "/")
    ResponseEntity<String> addNewKrevet(@RequestBody @Valid KrevetDAO krevetDAO){

        Krevet k = new Krevet();

        k.setNazivKreveta(krevetDAO.getNazivKreveta());
        k.setSobaId(krevetDAO.getSobaId());
        k.setZauzetost(krevetDAO.getZauzetost());

        krevetRepository.save(k);

        return ResponseEntity.ok("Bed has been added.");
    }

    @GetMapping(path = "/")
    public @ResponseBody Iterable<Krevet>getAllKreveti(){
        return krevetRepository.findAll();
    }

    @GetMapping(path = "/GetByNaziv/{nazivKreveta}")
    public @ResponseBody ResponseEntity<?> getKrevetByNaziv(@PathVariable("nazivKreveta") String nazivKreveta){

        try{
            Optional<Krevet> krevet = krevetRepository.findByNazivKreveta(nazivKreveta);

            if(krevet.isEmpty()) throw new NotFoundException("Krevet sa tim imenom nije pronadjen.");

            return ResponseEntity.ok(krevet);
        }catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/GetById/{id}")
    public @ResponseBody ResponseEntity<?> getKrevetId(@PathVariable("id") Integer id){

        try {
            Optional<Krevet> krevet = krevetRepository.findById(id);

            if(krevet.isEmpty()) throw new NotFoundException("Krevet sa tim id-em nije pronadjen");

            return  ResponseEntity.ok(krevet);
        }catch (NotFoundException e){

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping(path = "/Naziv/{id}")
    public @ResponseBody ResponseEntity<String> updateKrevetNaziv(@RequestBody String naziv, @PathVariable("id") Integer id){

        try{
            Optional<Krevet> krevet = krevetRepository.findById(id);

            if(krevet.isEmpty()) throw new NotFoundException("Krevet sa tim id-em nije pronadjen.");
            if(naziv == null || naziv.isEmpty() || naziv.isBlank()) throw new NotFoundException("Naziv ne smije biti prazan string.");

            Krevet krevet1 = krevet.get();

            krevet1.setNazivKreveta(naziv);

            krevetRepository.save(krevet1);

            return ResponseEntity.ok("The bed has been successfully updated");
        }
        catch (NotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping(path = "/SobaID/{id}")
    public @ResponseBody ResponseEntity<String> updateKrevetSobaId(@RequestBody String sobaId, @PathVariable("id") Integer id){

        try{
            Optional<Krevet> krevet = krevetRepository.findById(id);

            if(krevet.isEmpty()) throw new NotFoundException("Krevet sa tim id-em nije pronadjen.");
            if(sobaId == null || sobaId.isEmpty() || sobaId.isBlank()) throw new NotFoundException("SobaId ne smije biti prazan string.");

            Krevet krevet1 = krevet.get();

            krevet1.setSobaId(Integer.valueOf(sobaId));

            krevetRepository.save(krevet1);

            return ResponseEntity.ok("The bed has been successfully updated");
        }
        catch (NotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping(path = "/zauzetost/{id}")
    public @ResponseBody ResponseEntity<String> updateKrevetZauzetost(@RequestBody String zauzetost, @PathVariable("id") Integer id){

        try{
            Optional<Krevet> krevet = krevetRepository.findById(id);

            if(krevet.isEmpty()) throw new NotFoundException("Krevet sa tim id-em nije pronadjen.");
            if(zauzetost == null || zauzetost.isEmpty() || zauzetost.isBlank()) throw new NotFoundException("Polje zauzetost ne smije biti prazan string.");

            Krevet krevet1 = krevet.get();

            if(zauzetost.equals("true") || zauzetost.equals("false")){
                Boolean zauzet = Boolean.valueOf(zauzetost);

                krevet1.setZauzetost(zauzet);
                krevetRepository.save(krevet1);

                return ResponseEntity.ok("The bed has been successfully updated");
            }
            return new ResponseEntity<>("Nije ispravna vrijednost boolean-a.", HttpStatus.BAD_REQUEST);
        }
        catch (NotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "/byId/{id}")
    public @ResponseBody ResponseEntity<String> deleteKrevetById(@PathVariable("id") Integer id){

        try{
            Optional<Krevet> krevet = krevetRepository.findById(id);

            if(krevet.isEmpty()) throw new NotFoundException("Krevet sa tim id-em nije pronadjen.");

            krevetRepository.deleteById(id);

            return ResponseEntity.ok("The bed has been successfully deleted");
        }
        catch (NotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
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
