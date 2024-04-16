package com.etf.repository;

import com.etf.dao.PacijentDAO;
import com.etf.model.Pacijent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PacijentRepository extends CrudRepository<Pacijent, Integer> {

    public default void save(Pacijent pacijent, String id){
    }

    Optional<Pacijent> findById(Integer id);

    Pacijent findByIme(String ime);
}