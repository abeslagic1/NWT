package com.example.tit.dao;

import org.springframework.data.repository.CrudRepository;
import com.example.tit.model.Pacijent;
import org.springframework.stereotype.Repository;
//import java.util.Optional;

@Repository
public interface PacijentRepository extends CrudRepository<Pacijent, Integer> {

}
