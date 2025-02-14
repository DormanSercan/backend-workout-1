package com.sercandorman.bookesh.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {

    public static final String QUEUE = "orderQueue";

    @RabbitListener(queues = QUEUE)
    public void receiveMessage(String message) {
        System.out.println("Received order: " + message);
    }
}
