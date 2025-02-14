package com.sercandorman.bookesh.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sercandorman.bookesh.dto.OrderDTO;
import com.sercandorman.bookesh.model.Order;
import com.sercandorman.bookesh.rabbitmq.RabbitMQProducer;
import com.sercandorman.bookesh.repository.OrderRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RabbitMQProducer rabbitMQProducer;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public Order createOrder(OrderDTO orderDTO) {
        Order order = new Order(orderDTO.getCustomerName(), orderDTO.getFoodItem(), orderDTO.getQuantity());

        return orderRepository.save(order);
    }

    public void sendOrderToQueue(OrderDTO orderDTO) {
        try {
            //Convert DTO to JSON String and Send to RabbitMQ
            String orderJsonString = objectMapper.writeValueAsString(orderDTO);
            rabbitMQProducer.send(orderJsonString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
