package com.patrickbathu.covidfirebase.services;

import com.patrickbathu.covidfirebase.client.CovidApiProxy;
import com.patrickbathu.covidfirebase.dto.CovidDayOne;
import com.patrickbathu.covidfirebase.producers.MyCustom;
import com.patrickbathu.covidfirebase.repository.CovidDayOneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class CovidService {

    @Autowired
    private CovidApiProxy covidApiProxy;

    @Autowired
    private CovidDayOneRepository covidDayOneRepository;

    @Autowired
    private MyCustom myCustom;

    public ResponseEntity<String> updateBaseCovid(){
        return covidApiProxy.getCountries();
    }

    public void getCountryDayOneRoute(){
        log.info("CovidService.updateBase - start");
        List<CovidDayOne> list = covidApiProxy.getCountryDayOne();

        log.info("CovidService.updateBase [{}]", list.toString());

        for(CovidDayOne item : list){
            sendMessages(item);
        }

        log.info("CovidService.updateBase - end");
    }

    public  List<CovidDayOne> getAll(){
        List<CovidDayOne> covidAll = covidDayOneRepository.findAll();

        return covidAll;
    }

    private void sendMessages(CovidDayOne covidDayOne){
        try {
            log.info("CovidService.sendMessages msg: [{}]", covidDayOne.toString());
            myCustom.send(covidDayOne);
        }catch (Exception e){
            log.error("CovidService.sendMessages  ERROR:[{}] ", e);
        }

    }

}
