package com.sercandorman.bookesh.rabbitmq;

import com.sercandorman.bookesh.dto.OrderDTO;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public static final String EXCHANGE_NAME = "orderExchange";
    public static final String ROUTING_KEY = "order.routing.key";

    public void send(String stringOrderDTO) {
        //OrderListener(RabbitListener) will listen this.
        amqpTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, stringOrderDTO);
    }
}
