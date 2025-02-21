package com.sercandorman.bookesh.rabbitmq;

import com.sercandorman.bookesh.shared.Constants;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue orderQueue() {
        return new Queue(Constants.RMQ_ORDER_QUEUE, true);
    }

    @Bean
    public DirectExchange orderExchange() {
        return new DirectExchange(Constants.EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue orderQueue, DirectExchange orderExchange) {
        return BindingBuilder.bind(orderQueue) // Bind Queue To Exchange
                .to(orderExchange)
                .with(Constants.ROUTING_KEY);  // Messages will be routing with this key
    }
}

