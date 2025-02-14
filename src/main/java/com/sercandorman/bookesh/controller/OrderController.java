package com.sercandorman.bookesh.controller;

import com.sercandorman.bookesh.dto.OrderDTO;
import com.sercandorman.bookesh.model.Order;
import com.sercandorman.bookesh.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/{newOrder}")
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@RequestBody OrderDTO orderDTO) {
        // Send Order to RabbitMQ
        orderService.sendOrderToQueue(orderDTO);

        // Save Order to DB
        return orderService.createOrder(orderDTO);
    }
}
