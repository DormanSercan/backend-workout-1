package com.sercandorman.bookesh.model;

import jakarta.persistence.*;

@Entity
@Table(name = "FoodAndBeverage")
public class FoodAndBeverage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;

    public FoodAndBeverage() {
    }

    public FoodAndBeverage(Long id) {
        this.id = id;
    }

    public FoodAndBeverage(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
