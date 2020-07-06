package com.patrickbathu.covidbatch.config;

import com.patrickbathu.covidbatch.constants.RabbitMq;
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
    public TopicExchange covidExchange()
    {
        return new TopicExchange(RabbitMq.COVID_EXCHANGE);
    }

    @Bean
    public MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue covidQueue(){
        return QueueBuilder.durable(RabbitMq.COVID_QUEUE).withArgument(XDLE, "")
                .withArgument(XDLRK, RabbitMq.COVID_QUEUE_DEAD).build();
    }

    @Bean
    public Queue covidQueueDead(){
        return QueueBuilder.durable(RabbitMq.COVID_QUEUE_DEAD).build();
    }

    @Bean
    List<Binding> bindings(){
        return Arrays.asList(
                BindingBuilder.bind(covidQueue()).to(covidExchange())
                    .with(RabbitMq.COVID_ROUTING_KEY));
    }

}
