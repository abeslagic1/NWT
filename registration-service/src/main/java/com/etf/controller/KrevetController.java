package com.etf.controller;

import com.etf.dao.KrevetDAO;
import com.etf.model.Krevet;
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

@Validated
@RestController
@RequestMapping(path = "/Krevet")
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
