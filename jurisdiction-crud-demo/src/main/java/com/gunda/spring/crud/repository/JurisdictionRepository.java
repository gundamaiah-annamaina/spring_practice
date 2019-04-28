package com.gunda.spring.crud.repository;

import com.gunda.spring.crud.model.Jurisdiction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JurisdictionRepository extends JpaRepository<Jurisdiction,Long> {

    List<Jurisdiction> findByYear(Integer year);
}
