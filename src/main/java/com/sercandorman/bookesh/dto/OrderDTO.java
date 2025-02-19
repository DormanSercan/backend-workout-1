package com.sercandorman.bookesh.dto;

import java.util.List;

public class OrderDTO {

    private long customerId;
    private long restaurantId;
    private List<CartDTO> cartDTOList;

    public OrderDTO(long customerId, long restaurantId, List<CartDTO> cartDTOList) {
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.cartDTOList = cartDTOList;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<CartDTO> getCartDTOList() {
        return cartDTOList;
    }

    public void setCartDTOList(List<CartDTO> cartDTOList) {
        this.cartDTOList = cartDTOList;
    }
}

