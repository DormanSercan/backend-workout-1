package com.sercandorman.bookesh.rabbitmq;

import com.sercandorman.bookesh.dto.OrderDTO;
import com.sercandorman.bookesh.shared.Constants;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String stringOrderDTO) {
        //OrderListener(RabbitListener) will listen this.
        amqpTemplate.convertAndSend(Constants.EXCHANGE_NAME, Constants.ROUTING_KEY, stringOrderDTO);
    }
}
