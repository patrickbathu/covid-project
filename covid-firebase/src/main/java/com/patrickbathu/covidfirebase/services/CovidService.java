package com.patrickbathu.covidfirebase.services;

import com.patrickbathu.covidfirebase.client.CovidApiProxy;
import com.patrickbathu.covidfirebase.dto.CovidDayOne;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CovidService {

    @Autowired
    private CovidApiProxy covidApiProxy;

    private static final double CEM = 0.100;

    public void putCovidFirebase(CovidDayOne payload){
        log.info("CovidService.updateBase - start");
        log.info("CovidService.updateBase - payload [{}]", payload.toString());
        covidApiProxy.putCovid(payload);
        log.info("CovidService.updateBase - end");
    }

    private void deathRate(CovidDayOne payload){
        Double deathRate = (payload.getDeaths() * CEM ) * payload.getDeaths() ;
        payload.setDeathRate(deathRate.toString());

    }

    private void recoveryRate(CovidDayOne payload){

    }

    private void activeRate(CovidDayOne payload){

    }


    public static void main(String[] args) {
        Double deathRate = (100 * CEM ) / 1000 ;
        System.out.println(deathRate);
    }
}



