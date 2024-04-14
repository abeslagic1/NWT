package com.etf.repository;

import com.etf.model.Krevet;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface KrevetRepository extends CrudRepository<Krevet, Integer> {

    Krevet getById(int krevetID);

    Optional<Krevet>findById(Integer krevetID);
}
