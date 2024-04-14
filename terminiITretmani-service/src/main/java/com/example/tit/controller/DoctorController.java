package com.example.tit.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tit.dao.DoctorRepository;
import com.example.tit.exception.DoctorNotFoundException;
import com.example.tit.model.Doctor;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path="/doktori")
public class DoctorController {
    
    private final DoctorRepository doctorRepository;

    DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @GetMapping()
    Iterable<Doctor> all() {
        return doctorRepository.findAll();
    }

    @PostMapping()
    Doctor newDoctor(@Valid @RequestBody Doctor newDoctor) {
        return doctorRepository.save(newDoctor);
    }

    @GetMapping("/{docID}")
    Doctor one(@PathVariable int docID) {
        return doctorRepository.findById(docID).orElseThrow(() -> new DoctorNotFoundException(docID));
    }

    @PutMapping("/{docID}")
    Doctor replaceDoctor(@RequestBody Doctor newDoctor, @PathVariable int docID) {

        return doctorRepository.findById(docID).map(doctor -> {
            doctor.setName(newDoctor.getName());
            doctor.setSurrname(newDoctor.getSurrname());
            doctor.setSpecialization(newDoctor.getSpecialization());
            return doctorRepository.save(doctor);
        })
        .orElseGet(() -> {
            newDoctor.setID(docID);
            return doctorRepository.save(newDoctor);
        });
    }

    @DeleteMapping("/{docID}")
    void deleteDoctor(@PathVariable int docID) {
        doctorRepository.deleteById(docID);
    }

    //@PostMapping(path = "/addDoktor")
    //public @ResponseBody String addNewDoctor (@RequestBody String ime, @RequestBody String prezime, @RequestBody String specijalizacija) {

      //  Doctor doctor = new Doctor();
        //doctor.setName(ime);
        //doctor.setSurrname(prezime);
        //doctor.setSpecialization(specijalizacija);
        //doctorRepository.save(doctor);
        //return "Saved";
    //}

    //@GetMapping(path = "/allDoktor")
    //public @ResponseBody Iterable<Doctor> getAllDoctors() {
      //  return doctorRepository.findAll();
    //}
}