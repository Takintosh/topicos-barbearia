package org.takintosh.domain.models;

import java.time.LocalDateTime;

public class Appointment {
    private Integer id;
    private LocalDateTime date;
    private Client client;
    private Barber barber;

    public Appointment(LocalDateTime date, Client client, Barber barber) {
        // Validate Client
        if (client == null) {
            throw new IllegalArgumentException("Client is required");
        }
        // Validate Barber
        if (barber == null) {
            throw new IllegalArgumentException("Barber is required");
        }

        this.date = date;
        this.client = client;
        this.barber = barber;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
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

    public Barber getBarber() {
        return barber;
    }
    public void setBarber(Barber barber) {
        if (barber == null) {
            throw new IllegalArgumentException("Barber is required");
        }
        this.barber = barber;
    }

}