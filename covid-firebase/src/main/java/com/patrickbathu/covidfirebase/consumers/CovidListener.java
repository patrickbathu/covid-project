package com.patrickbathu.covidfirebase.consumers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.patrickbathu.covidfirebase.constants.RabbitMq;
import com.patrickbathu.covidfirebase.dto.CovidDayOne;
import com.patrickbathu.covidfirebase.services.CovidService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CovidListener {

    @Autowired
    private CovidService covidService;


    @RabbitListener(queues = RabbitMq.COVID_QUEUE)
    public void process(@Payload String msg) {
        CovidDayOne covid = (CovidDayOne) parseStringToObject(msg, CovidDayOne.class);

        log.info("CovidListener.process msg:[{}]", covid.toString());

       covidService.putCovidFirebase(covid);

        log.info("CovidListener.process - end");
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
