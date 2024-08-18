package org.takintosh.domain.models;

public class Financial {
    private Long id;
    private double saleValue;
    private Product product;
    private Barber barber;
    private Client client;

    public Financial(Long id, double saleValue, Product product, Barber barber, Client client) {
        this.id = id;
        this.saleValue = saleValue;
        this.product = product;
        this.barber = barber;
        this.client = client;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public double getSaleValue() {
        return saleValue;
    }
    public void setSaleValue(double saleValue) {
        this.saleValue = saleValue;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    public Barber getBarber() {
        return barber;
    }
    public void setBarber(Barber barber) {
        this.barber = barber;
    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
}
