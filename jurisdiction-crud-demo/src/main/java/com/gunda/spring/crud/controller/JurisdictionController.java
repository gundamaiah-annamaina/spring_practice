package com.gunda.spring.crud.controller;


import com.gunda.spring.crud.model.Jurisdiction;
import com.gunda.spring.crud.service.JurisdictionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("itra")
public class JurisdictionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(JurisdictionController.class);

    @Autowired
    private JurisdictionService jurisdictionService;

    //READ
    @GetMapping("/getAllJurisByYear")
    public ResponseEntity<List<Jurisdiction>> getAllJurisByYear(@RequestParam Integer year) {
        LOGGER.info("getAllJurisByYear : STARTS");
        List<Jurisdiction> allJurisByYear = jurisdictionService.getAllJurisByYear(year);
        LOGGER.info("", allJurisByYear);
        return ResponseEntity.ok(allJurisByYear);
    }

    //CREATE
    @PostMapping("/createJuris")
    public ResponseEntity<Jurisdiction> createJurisdiction(@RequestBody Jurisdiction jurisdiction) {
        LOGGER.info("createJurisdiction : STARTS");
        Jurisdiction savedJurisdiction = jurisdictionService.createJurisdiction(jurisdiction);
        LOGGER.info("" + jurisdiction);
        LOGGER.info("createJurisdiction : ENDS");
        return ResponseEntity.ok(savedJurisdiction);
    }


    //CREATEMULTIPLE,UPDATE,DELETE,DELETEALL

}
