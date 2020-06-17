package com.patrickbathu.covidfirebase.producers;

import com.patrickbathu.covidfirebase.constants.RabbitMq;
import com.patrickbathu.covidfirebase.dto.CovidDayOne;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyCustom {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(CovidDayOne payload){
        log.info("MyCustom.send [{}]: ", payload);
        rabbitTemplate.convertAndSend(RabbitMq.COVID_EXCHANGE, RabbitMq.COVID_ROUTING_KEY, payload.toString());
    }

}
