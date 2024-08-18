package org.takintosh.domain.builders;

import org.takintosh.domain.models.Product;

public class ProductBuilder {
    private int id;
    private String name;
    private double price;
    private double commission;
    private int quantity;

    public ProductBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public ProductBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder withPrice(double price) {
        this.price = price;
        return this;
    }

    public ProductBuilder withCommission(double commission) {
        this.commission = commission;
        return this;
    }

    public ProductBuilder withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public Product build() {
        return new Product(id, name, price, commission, quantity);
    }
}