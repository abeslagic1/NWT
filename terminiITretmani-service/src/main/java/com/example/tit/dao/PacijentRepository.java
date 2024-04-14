package com.example.tit.dao;

import org.springframework.data.repository.CrudRepository;
import com.example.tit.model.Pacijent;

public interface PacijentRepository extends CrudRepository<Pacijent, Integer> {
    
}
