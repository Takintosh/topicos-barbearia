package org.takintosh.domain.models;

public class Product {
    private Integer id;
    private String name;
    private double price;
    private double commission;
    private int quantity;

    private static final double MIN_COMMISSION = 0.0;
    private static final double MAX_COMMISSION = 1.0;
    private static final double MIN_PRICE = 0.0;

    public Product(String name, double price, double comission, int quantity) {
        // Validate Name
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        // Validate Price
        if (price <= MIN_PRICE) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }
        // Validate Commission
        if (comission < MIN_COMMISSION || comission > MAX_COMMISSION) {
            throw new IllegalArgumentException("Commission must be between 0 and 1");
        }
        // Validate Quantity
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }

        this.name = name;
        this.price = price;
        this.commission = comission;
        this.quantity = quantity;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
    public void setPrice(double price) {
        if (price <= MIN_PRICE) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }
        this.price = price;
    }

    public double getCommission() {
        return commission;
    }
    public void setComission(double comission) {
        if (comission < MIN_COMMISSION || comission > MAX_COMMISSION) {
            throw new IllegalArgumentException("Commission must be between 0 and 1");
        }
        this.commission = comission;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.quantity = quantity;
    }

    // Stock control
    public void increaseQuantity(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount to increase cannot be negative");
        }
        this.quantity += amount;
    }
    public void decreaseQuantity(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount to decrease cannot be negative");
        }
        if(amount > this.quantity) {
            throw new IllegalArgumentException("Not enough quantity in stock.");
        }
        this.quantity -= amount;
    }

}