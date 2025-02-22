package com.sercandorman.bookesh.driverfinder.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sercandorman.bookesh.driverfinder.dto.OrderInformationDTO;
import com.sercandorman.bookesh.driverfinder.dto.OrderServiceResponse;
import com.sercandorman.bookesh.driverfinder.model.OrderDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class DriverFinderService {

    private final WebClient webClient;

    @Autowired
    public DriverFinderService(WebClient.Builder webClientBuilder) {
        String baseUrl = "http://localhost:8080";
        this.webClient = webClientBuilder.baseUrl(baseUrl).build();
    }

    public OrderServiceResponse parseOrderMessage(String message) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(message, OrderServiceResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Order JSON Parsing Failed!", e);
        }
    }

    public void receiveOrderResponseAndParse(OrderServiceResponse orderServiceResponse) {
        OrderDriver orderDriver = new OrderDriver(31L,"MockDriver");
        OrderInformationDTO orderInformationDTO = new OrderInformationDTO(
                orderServiceResponse.getId(),
                orderServiceResponse.getRestaurant().getId(),
                orderServiceResponse.getCustomer().getId(),
                orderDriver.getId());
        sendOrderCompletion(orderInformationDTO);
    }

    public void sendOrderCompletion(OrderInformationDTO orderInfoDTO) {
        webClient.post()
                .uri("/api/orderCompleted") // Endpoint of OrderService to complete Order
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(orderInfoDTO)
                .retrieve()
                .bodyToMono(String.class)
                .doOnSuccess(response -> System.out.println("Order completion sent: " + response))
                .doOnError(error -> System.err.println("Error sending order completion: " + error.getMessage()))
                .subscribe();
    }
}
