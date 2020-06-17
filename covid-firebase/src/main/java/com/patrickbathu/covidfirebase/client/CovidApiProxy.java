package com.patrickbathu.covidfirebase.client;

import com.patrickbathu.covidfirebase.dto.CovidDayOne;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CovidApiProxy {

    private static final String COUNTRY_BRAZIL = "brazil";

    @Autowired
    private CovidApiClient covidApiClient;

    public CovidDayOne putCovid(CovidDayOne covidDayOne, String id){
        log.info("CovidApiProxy.putCovid - start - covidDayOne [{}]", covidDayOne.toString());
        return covidApiClient.putCovid(covidDayOne, id);
    }
}
