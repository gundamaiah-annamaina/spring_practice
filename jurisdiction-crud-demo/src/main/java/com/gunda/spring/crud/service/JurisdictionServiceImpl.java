package com.gunda.spring.crud.service;

import com.gunda.spring.crud.model.Jurisdiction;
import com.gunda.spring.crud.repository.JurisdictionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JurisdictionServiceImpl implements JurisdictionService {

    @Autowired
    private JurisdictionRepository jurisdictionRepository;

    @Override
    public List<Jurisdiction> getAllJurisByYear(Integer year) {
        return jurisdictionRepository.findByYear(year);
    }

    @Override
    public Jurisdiction createJurisdiction(Jurisdiction jurisdiction) {
        return jurisdictionRepository.save(jurisdiction);
    }
}
