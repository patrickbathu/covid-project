package com.patrickbathu.covidfirebase.controllers;


import com.patrickbathu.covidfirebase.dto.CovidDayOne;
import com.patrickbathu.covidfirebase.services.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CovidController {

    @Autowired
    private CovidService covidService;


    @GetMapping(value = "/v1/covid/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CovidDayOne>> getAll(){
        return new ResponseEntity<>(covidService.getAll(), HttpStatus.OK) ;
    }

    @GetMapping(value = "/v1/service/up", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getServiceUp(){
        return new ResponseEntity<String>(HttpStatus.OK);
    }

}
