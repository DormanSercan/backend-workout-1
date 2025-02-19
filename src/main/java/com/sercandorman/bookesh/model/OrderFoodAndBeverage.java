package com.sercandorman.bookesh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "OrderFoodAndBeverage")
public class OrderFoodAndBeverage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "OrderId")
    @JsonIgnore
    private Order order;

    @ManyToOne
    @JoinColumn(name = "FoodAndBeverageId")
    private FoodAndBeverage foodAndBeverage;

    private int quantity;

    public OrderFoodAndBeverage() {
    }

    public OrderFoodAndBeverage(Order order, FoodAndBeverage foodAndBeverage, int quantity) {
        this.order = order;
        this.foodAndBeverage = foodAndBeverage;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public FoodAndBeverage getFoodAndBeverage() {
        return foodAndBeverage;
    }

    public void setFoodAndBeverage(FoodAndBeverage foodAndBeverage) {
        this.foodAndBeverage = foodAndBeverage;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
