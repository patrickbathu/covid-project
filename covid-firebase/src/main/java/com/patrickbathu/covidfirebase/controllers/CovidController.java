package com.patrickbathu.covidfirebase.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CovidController {

    @GetMapping(value = "/v1/service/up", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getUp(){
        return new ResponseEntity(HttpStatus.OK);
    }

}
