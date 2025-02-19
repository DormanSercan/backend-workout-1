package com.sercandorman.bookesh.listener;

import com.sercandorman.bookesh.shared.Constants;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {

    @RabbitListener(queues = Constants.RMQ_ORDER_QUEUE)
    public void receiveMessage(String message) {System.out.println(Constants.RECEIVED_ORDER + message);
    }
}
