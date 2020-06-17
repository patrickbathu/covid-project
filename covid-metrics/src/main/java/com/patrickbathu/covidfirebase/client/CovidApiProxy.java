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

    @Cacheable("listCovidDayOne")
    public List<CovidDayOne> getCountryDayOne(){
        log.info("CovidApiProxy.getCountryDayOne");
        return covidApiClient.getCountryDayOneRoute(COUNTRY_BRAZIL);
    }

    public ResponseEntity<String> getCountries(){
        log.info("CovidApiProxy.getCountryDayOne");
        return covidApiClient.getCountriesRoute();
    }

}
