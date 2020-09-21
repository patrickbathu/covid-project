package com.patrickbathu.covidfirebase.config;

import com.patrickbathu.covidfirebase.constants.RabbitMq;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class RabbitConfig {

    public static final String XDLE = "x-dead-letter-exchange";

    public static final String XDLRK = "x-dead-letter-routing-key";

    @Bean
    public Queue covidQueue(){
        return QueueBuilder.durable(RabbitMq.COVID_QUEUE).withArgument(XDLE, "")
                .withArgument(XDLRK, RabbitMq.COVID_QUEUE_DEAD).build();
    }

    @Bean
    public Queue covidQueueDead(){
        return QueueBuilder.durable(RabbitMq.COVID_QUEUE_DEAD).build();
    }

//    @Bean
//    public Declarables queues(){
//        return new Declarables(
//                new Queue(RabbitMq.COVID_QUEUE, true),
//                new Queue(RabbitMq.COVID_QUEUE_DEAD, true )
//        );
//    }

    @Bean
    public Declarables bindings(){
        return new Declarables(
                new Binding(RabbitMq.COVID_QUEUE, Binding.DestinationType.QUEUE, RabbitMq.COVID_EXCHANGE, RabbitMq.COVID_ROUTING_KEY, null)
        );
    }

}
