package com.patrickbathu.covidbatch.producers;

import com.patrickbathu.covidbatch.constants.RabbitMq;
import com.patrickbathu.covidbatch.dto.CovidDayOne;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CovidPublish {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(CovidDayOne payload){
        log.info("CovidPublish.send [{}]: ", payload);
        rabbitTemplate.convertAndSend(RabbitMq.COVID_EXCHANGE, RabbitMq.COVID_ROUTING_KEY, payload.toString());
    }

}
