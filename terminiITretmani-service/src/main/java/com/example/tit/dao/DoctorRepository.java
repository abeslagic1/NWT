package com.example.tit.dao;

//import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.example.tit.model.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
    
    //Optional<Doctor> findDoctorID(Integer docID);
}
