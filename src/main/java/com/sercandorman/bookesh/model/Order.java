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

    public Order() {
    }

    public Order(Customer customer, Restaurant restaurant, Double totalPrice) {
        this.customer = customer;
        this.restaurant = restaurant;
        this.totalPrice = totalPrice;
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
}
