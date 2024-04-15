package com.etf.controller;


import com.etf.dao.PacijentDAO;
import com.etf.exceptions.NotFoundException;
import com.etf.model.Pacijent;
import com.etf.repository.PacijentRepository;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Validated
@RestController
@RequestMapping(path = "/Pacijent")
public class PacijentController {

    @Autowired          // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private PacijentRepository pacijentRepository;



    @PostMapping(path = "/")
    ResponseEntity <String> addNewPacijent(@RequestBody @Valid PacijentDAO pacijentDAO) {

        Pacijent p = new Pacijent();

        p.setIme(pacijentDAO.getIme());
        p.setPrezime(pacijentDAO.getPrezime());
        p.setSamUSobi(pacijentDAO.getSamUSobi());

        pacijentRepository.save(p);

        return ResponseEntity.ok("The patient has been successfully added.");
    }

    @GetMapping(path = "/")
    public @ResponseBody Iterable<Pacijent> getAllPacijents(){
        //This returns a JSON or XML with the pacijents
        return pacijentRepository.findAll();
    }

    @GetMapping(path = "/GetByIme/{ime}")
    public ResponseEntity<?> getPacijentName(@PathVariable("ime") String ime){
        //This returns a JSON or XML with the pacijents

        try{
            Pacijent pacijent = pacijentRepository.findByIme(ime);

            if (pacijent == null) throw new NotFoundException("Pacijent pod tim imenom nije pronadjen.");

            return ResponseEntity.ok(pacijent);
        }catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/GetById/{id}")
    public Optional<Pacijent> getPacijentId(@PathVariable("id") Integer id){
        //This returns a JSON or XML with the pacijents
        return pacijentRepository.findById(id);
    }

    @PutMapping(path = "/{id}")
    ResponseEntity<String> updatePacijent(@RequestBody Pacijent pacijent, @PathVariable("id") String id){

        pacijentRepository.save(pacijent, id);
        return ResponseEntity.ok("The patient has been successfully updated");
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



