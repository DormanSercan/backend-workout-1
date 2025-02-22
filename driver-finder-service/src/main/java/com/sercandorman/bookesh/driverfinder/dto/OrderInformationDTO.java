package com.sercandorman.bookesh.driverfinder.dto;

public class OrderInformationDTO {

    private Long orderId;
    private Long restaurantId;
    private Long customerId;
    private Long orderDriverId;

    public OrderInformationDTO() {
    }

    public OrderInformationDTO(Long orderId, Long restaurantId, Long customerId, Long orderDriverId) {
        this.orderId = orderId;
        this.restaurantId = restaurantId;
        this.customerId = customerId;
        this.orderDriverId = orderDriverId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getOrderDriverId() {
        return orderDriverId;
    }

    public void setOrderDriverId(Long orderDriverId) {
        this.orderDriverId = orderDriverId;
    }
}

