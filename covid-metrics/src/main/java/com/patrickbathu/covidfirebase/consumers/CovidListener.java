package com.patrickbathu.covidfirebase.consumers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.patrickbathu.covidfirebase.constants.RabbitMq;
import com.patrickbathu.covidfirebase.dto.CovidDayOne;
import com.patrickbathu.covidfirebase.repository.CovidDayOneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class CovidListener {

    @Autowired
    private CovidDayOneRepository covidDayOneRepository;

    @RabbitListener(queues = RabbitMq.COVID_QUEUE)
    public void process(@Payload String msg) {
        CovidDayOne covid = (CovidDayOne) parseStringToObject(msg, CovidDayOne.class);

        log.info("CovidListener.process msg:[{}]", msg);

        if(isSave(covid)){
            CovidDayOne covidDayOne = covidDayOneRepository.save(covid);
            log.info("CovidListener.process save:[{}]", covidDayOne.toString());
        }else {
            log.info("CovidListener.process - NO UPDATE");
        }

        log.info("CovidListener.process - end");
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
