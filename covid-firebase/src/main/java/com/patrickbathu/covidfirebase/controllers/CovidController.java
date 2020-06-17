package com.patrickbathu.covidfirebase.controllers;


import com.patrickbathu.covidfirebase.dto.CovidDayOne;
import com.patrickbathu.covidfirebase.services.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CovidController {

    @Autowired
    private CovidService covidService;

    @PutMapping(value = "/v1/covid/{id}/firebase", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void put(@RequestBody CovidDayOne payload, @PathVariable String id){
        covidService.putCovidFirebase(payload, id);
    }

}
