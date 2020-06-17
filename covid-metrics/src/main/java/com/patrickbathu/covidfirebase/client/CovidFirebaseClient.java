package com.patrickbathu.covidfirebase.client;

import com.patrickbathu.covidfirebase.dto.CovidDayOne;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "covid-firebase", url = "${covid-firebase.url}")
public interface CovidFirebaseClient {

    @PutMapping(path = "${covid-firebase.put-covid-id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> putCovidFirebase(@RequestBody CovidDayOne covidDayOne, @PathVariable String id);

    @PostMapping(path = "${covid-firebase.put-covid-id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> postCovidFirebase(@RequestBody CovidDayOne covidDayOne, @PathVariable String id);

}
