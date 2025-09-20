package com.devsuperior.entities;

public class Product {

    private String name;
    private Double price;

    public Product(){

    };

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void updatePrice(Double newPrice) {
        this.price = newPrice;
    }

}
