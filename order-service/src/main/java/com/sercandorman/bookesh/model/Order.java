package com.sercandorman.bookesh.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CustomerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "RestaurantId")
    private Restaurant restaurant;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderFoodAndBeverage> orderFoodAndBeverageList;

    private Double totalPrice;

    private Boolean orderDelivered;

    private Long orderDriverId;

    public Order() {
    }

    public Order(Customer customer, Restaurant restaurant, Double totalPrice, Boolean orderDelivered, Long orderDriverId) {
        this.customer = customer;
        this.restaurant = restaurant;
        this.totalPrice = totalPrice;
        this.orderDelivered = orderDelivered;
        this.orderDriverId = orderDriverId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<OrderFoodAndBeverage> getOrderFoodAndBeverageList() {
        return orderFoodAndBeverageList;
    }

    public void setOrderFoodAndBeverageList(List<OrderFoodAndBeverage> orderFoodAndBeverageList) {
        this.orderFoodAndBeverageList = orderFoodAndBeverageList;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Boolean getOrderDelivered() {
        return orderDelivered;
    }

    public void setOrderDelivered(Boolean orderDelivered) {
        this.orderDelivered = orderDelivered;
    }

    public Long getOrderDriverId() {
        return orderDriverId;
    }

    public void setOrderDriverId(Long orderDriverId) {
        this.orderDriverId = orderDriverId;
    }
}
