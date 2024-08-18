package org.takintosh.domain.models;

public class Financial {
    private Integer id;
    private double saleValue;
    private Product product;
    private Barber barber;
    private Client client;

    public Financial(double saleValue, Product product, Barber barber, Client client) {
        // Validate Sale Value
        if (saleValue <= 0) {
            throw new IllegalArgumentException("Sale value must be greater than 0");
        }
        // Validate Product
        if (product == null) {
            throw new IllegalArgumentException("Product is required");
        }
        // Validate Barber
        if (barber == null) {
            throw new IllegalArgumentException("Barber is required");
        }
        // Validate Client
        if (client == null) {
            throw new IllegalArgumentException("Client is required");
        }

        this.saleValue = saleValue;
        this.product = product;
        this.barber = barber;
        this.client = client;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public double getSaleValue() {
        return saleValue;
    }
    public void setSaleValue(double saleValue) {
        if (saleValue <= 0) {
            throw new IllegalArgumentException("Sale value must be greater than 0");
        }
        this.saleValue = saleValue;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product is required");
        }
        this.product = product;
    }

    public Barber getBarber() {
        return barber;
    }
    public void setBarber(Barber barber) {
        if (barber == null) {
            throw new IllegalArgumentException("Barber is required");
        }
        this.barber = barber;
    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        if (client == null) {
            throw new IllegalArgumentException("Client is required");
        }
        this.client = client;
    }

}