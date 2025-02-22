package com.sercandorman.bookesh.dto;

public class CartDTO {

    private Long foodAndBeverageId;
    private int quantity;

    public CartDTO(Long foodAndBeverageId, int quantity) {
        this.foodAndBeverageId = foodAndBeverageId;
        this.quantity = quantity;
    }

    public Long getFoodAndBeverageId() {
        return foodAndBeverageId;
    }

    public void setFoodAndBeverageId(Long foodAndBeverageId) {
        this.foodAndBeverageId = foodAndBeverageId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
