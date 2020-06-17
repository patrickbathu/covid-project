package com.patrickbathu.covidfirebase.client;

import com.patrickbathu.covidfirebase.dto.CovidDayOne;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "covid-api", url = "${api-covid.endpoint}")
public interface CovidApiClient {

    @GetMapping(path = "${api-covid.countriesRoute}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> getCountriesRoute();

    
    @GetMapping(path = "${api-covid.countryDayOneTotalRoute}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    List<CovidDayOne> getCountryDayOneRoute(@PathVariable("country") String country);


   }
