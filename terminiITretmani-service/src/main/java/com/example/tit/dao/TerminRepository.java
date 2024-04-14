package com.example.tit.dao;

import org.springframework.data.repository.CrudRepository;
import com.example.tit.model.Termin;

public interface TerminRepository extends CrudRepository<Termin, Integer> {
    
}
