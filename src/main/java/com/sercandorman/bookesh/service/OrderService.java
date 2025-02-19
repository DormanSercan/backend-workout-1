package com.sercandorman.bookesh.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sercandorman.bookesh.dto.OrderDTO;
import com.sercandorman.bookesh.model.*;
import com.sercandorman.bookesh.helper.APIHelper;
import com.sercandorman.bookesh.rabbitmq.RabbitMQProducer;
import com.sercandorman.bookesh.repository.CustomerRepository;
import com.sercandorman.bookesh.repository.FoodAndBeverageRepository;
import com.sercandorman.bookesh.repository.OrderRepository;
import com.sercandorman.bookesh.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private FoodAndBeverageRepository foodAndBeverageRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private RabbitMQProducer rabbitMQProducer;

    public Order createOrder(OrderDTO orderDTO) {
        Order order = new Order(
                customerRepository.findByIdOrThrow(orderDTO.getCustomerId()),
                restaurantRepository.findByIdOrThrow(orderDTO.getRestaurantId()),
                APIHelper.calculateCartTotalPrice(orderDTO.getCartDTOList(), foodAndBeverageRepository));
        orderRepository.save(order);

        List<OrderFoodAndBeverage> orderFoodAndBeverageList = APIHelper.prepareOrderFoodAndBeverageList(order, orderDTO.getCartDTOList());
        order.setOrderFoodAndBeverageList(orderFoodAndBeverageList);
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
