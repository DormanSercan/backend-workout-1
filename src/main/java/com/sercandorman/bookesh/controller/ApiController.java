package com.sercandorman.bookesh.controller;

import com.sercandorman.bookesh.dto.OrderDTO;
import com.sercandorman.bookesh.dto.OrderInformationDTO;
import com.sercandorman.bookesh.exception.CustomException;
import com.sercandorman.bookesh.model.Order;
import com.sercandorman.bookesh.service.OrderService;
import com.sercandorman.bookesh.shared.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/newOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@RequestBody OrderDTO orderDTO) {
        try {
            Order order = orderService.createOrder(orderDTO);
            // Send Order to RabbitMQ
            orderService.sendOrderToQueue(order);
            // Save Order to DB
            return order;
        } catch (Exception e) {
            throw new CustomException(Constants.ERROR_CREATE_ORDER + Constants.COLON_WITH_SPACES + e.getMessage());
        }
    }

    @PostMapping("/orderCompleted")
    @ResponseStatus(HttpStatus.CREATED)
    public void completeOrder(@RequestBody OrderInformationDTO orderInformationDTO) {
        try {
            orderService.updateOrder(orderInformationDTO);
        } catch (Exception e) {
            throw new CustomException(Constants.ERROR_UPDATE_ORDER + Constants.COLON_WITH_SPACES + e.getMessage());
        }
    }
}
