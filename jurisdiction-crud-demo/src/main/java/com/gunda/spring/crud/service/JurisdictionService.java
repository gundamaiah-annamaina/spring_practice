package com.gunda.spring.crud.service;

import com.gunda.spring.crud.model.Jurisdiction;

import java.util.List;

public interface JurisdictionService {
    List<Jurisdiction> getAllJurisByYear(Integer year);

    Jurisdiction createJurisdiction(Jurisdiction jurisdiction);
}
