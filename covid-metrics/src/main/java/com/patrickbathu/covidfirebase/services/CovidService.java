package com.patrickbathu.covidfirebase.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.patrickbathu.covidfirebase.dto.CovidDayOne;
import com.patrickbathu.covidfirebase.repository.CovidDayOneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class CovidService {

    @Autowired
    private CovidDayOneRepository covidDayOneRepository;

    public  List<CovidDayOne> getAll(){
        log.info("CovidService.getAll - start");
        List<CovidDayOne> covidAll = covidDayOneRepository.findAll();
        log.info("CovidService.getAll - end");
        return covidAll;
    }

    private boolean isSave(CovidDayOne msg){
        List<CovidDayOne> listBase = covidDayOneRepository.findAll();

        for(CovidDayOne item : listBase){
            if(item.getDate().equals(msg.getDate())){
                return Boolean.FALSE;
            }
        }

        return Boolean.TRUE;
    }

    private static Object parseStringToObject(String value, Class<?> type){
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(value, type);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }


}
