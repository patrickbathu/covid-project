package com.patrickbathu.covidbatch.controllers;


import com.patrickbathu.covidbatch.dto.CovidDayOne;
import com.patrickbathu.covidbatch.services.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CovidController {

    @Autowired
    private CovidService covidService;

    @PostMapping(value = "/v1/covid/forceUpdate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> forceUpdate(){
        covidService.getCountryDayOneRoute();
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/v1/service/up", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getUp(){
        return new ResponseEntity(HttpStatus.OK);
    }

}
