package org.takintosh.domain.builders;

import org.takintosh.domain.models.Appointment;
import org.takintosh.domain.models.Barber;
import org.takintosh.domain.models.Client;

import java.time.LocalDateTime;

public class AppointmentBuilder {
    private Long id;
    private LocalDateTime date;
    private Client client;
    private Barber barber;

    public AppointmentBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public AppointmentBuilder withDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public AppointmentBuilder withClient(Client client) {
        this.client = client;
        return this;
    }

    public AppointmentBuilder withBarber(Barber barber) {
        this.barber = barber;
        return this;
    }

    public Appointment build() {
        return new Appointment(id, date, client, barber);
    }
}