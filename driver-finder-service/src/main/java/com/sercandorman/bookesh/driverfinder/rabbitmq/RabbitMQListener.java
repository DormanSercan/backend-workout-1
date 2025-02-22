package com.sercandorman.bookesh.driverfinder.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sercandorman.bookesh.driverfinder.dto.OrderInformationDTO;
import com.sercandorman.bookesh.driverfinder.dto.OrderServiceResponse;
import com.sercandorman.bookesh.driverfinder.service.DriverFinderService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListener {

    @Autowired
    DriverFinderService driverFinderService;

    @RabbitListener(queues = "orderQueue")  // listens "orderQueue"
    public void receiveOrderMessage(String message) {
        System.out.println("Received order message: " + message);

        // Parse JSON string message from RabbitMQ to an Object
        OrderServiceResponse orderServiceResponse = driverFinderService.parseOrderMessage(message);
        // Convert message to DTO
        driverFinderService.receiveOrderResponseAndParse(orderServiceResponse);
    }

}

