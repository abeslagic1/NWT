package com.example.tit.dao;

import org.springframework.data.repository.CrudRepository;
import com.example.tit.model.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
    
}
