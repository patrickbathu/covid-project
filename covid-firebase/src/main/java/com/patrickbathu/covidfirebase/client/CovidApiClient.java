package com.patrickbathu.covidfirebase.client;

import com.patrickbathu.covidfirebase.dto.CovidDayOne;
import feign.Body;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "firebase-api", url = "${firebase-api.endpoint}")
public interface CovidApiClient {

    @PostMapping(path = "${firebase-api.base}", produces = MediaType.TEXT_PLAIN_VALUE)
    ResponseEntity<CovidDayOne> postCovid(String payload);

    @PutMapping(path = "${firebase-api.covid-id}", produces = MediaType.TEXT_PLAIN_VALUE)
    CovidDayOne putCovid(@RequestBody CovidDayOne payload, @PathVariable String id);

    @GetMapping(path = "${firebase-api.associados}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CovidDayOne> getAssociados();

    @GetMapping(path = "${firebase-api.base}", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<CovidDayOne> getCovid();

   }
