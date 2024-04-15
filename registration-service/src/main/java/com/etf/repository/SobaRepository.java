package com.etf.repository;

import com.etf.model.Soba;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SobaRepository extends CrudRepository<Soba, Integer> {

    Optional<Soba> findById(Integer id);

    Optional<Soba> findByNazivSobe(String nazivSobe);

}
