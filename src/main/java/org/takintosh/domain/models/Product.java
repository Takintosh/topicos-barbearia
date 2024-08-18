package org.takintosh.domain.models;

public class Product {
    private int id;
    private String name;
    private double price;
    private double comission;
    private int quantity;

    public Product(int id, String name, double price, double comission, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.comission = comission;
        this.quantity = quantity;
    }

    // Getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
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
        this.price = price;
    }

    public double getComission() {
        return comission;
    }
    public void setComission(double comission) {
        this.comission = comission;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //Stock control
    public void increaseQuantity(int amount) {
        this.quantity += amount;
    }
    public void decreaseQuantity(int amount) {
        if(amount<=this.quantity){
            this.quantity -= amount;
        } else {
            throw new IllegalArgumentException("Not enough quantity in stock.");
        }
    }

}
