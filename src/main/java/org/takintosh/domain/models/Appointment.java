package org.takintosh.domain.models;

import java.time.LocalDateTime;

public class Appointment {
    private int id;
    private LocalDateTime date;
    private Client client;
    private Barber barber;

    public Appointment(int id, LocalDateTime date, Client client, Barber barber) {
        this.id = id;
        this.date = date;
        this.client = client;
        this.barber = barber;
    }

    // Getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
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
        this.client = client;
    }

    public Barber getBarber() {
        return barber;
    }
    public void setBarber(Barber barber) {
        this.barber = barber;
    }
}
