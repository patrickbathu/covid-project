package com.patrickbathu.covidbatch.services;

import com.patrickbathu.covidbatch.client.CovidApiProxy;
import com.patrickbathu.covidbatch.dto.CovidDayOne;
import com.patrickbathu.covidbatch.producers.CovidPublish;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CovidService {

    @Autowired
    private CovidApiProxy covidApiProxy;

    @Autowired
    private CovidPublish covidPublish;

    public void getCountryDayOneRoute(){
        log.info("CovidService.updateBase - start");
        List<CovidDayOne> list = covidApiProxy.getCountryDayOne();

        log.info("CovidService.updateBase [{}]", list.toString());

        for(CovidDayOne item : list){
            covidPublish.send(item);
        }

        log.info("CovidService.updateBase - end");
    }

}
