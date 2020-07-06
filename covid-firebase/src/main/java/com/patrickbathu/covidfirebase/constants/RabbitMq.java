package com.patrickbathu.covidfirebase.constants;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RabbitMq {

    // deadletter
    public static final String DEAD = ".dead";

    //topic
    public static final String COVID_EXCHANGE =  "covid-exchange";

    //prefixo
    public static final String QUEUE_NAME_PREFIX =  "covid.firebase.";

    //routes
    public static final String COVID_ROUTING_KEY =  "queue.update";

    //Queues
    public static final String COVID_QUEUE = QUEUE_NAME_PREFIX + COVID_ROUTING_KEY;

    // Dead queues
    public static final String COVID_QUEUE_DEAD = QUEUE_NAME_PREFIX + COVID_ROUTING_KEY + DEAD;

}
