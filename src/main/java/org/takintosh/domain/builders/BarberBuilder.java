package org.takintosh.domain.builders;

import org.takintosh.domain.models.Barber;

public class BarberBuilder {
    private String name;
    private String schedules;

    public BarberBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public BarberBuilder withSchedules(String schedules) {
        this.schedules = schedules;
        return this;
    }

    public Barber build() {
        return new Barber(name, schedules);
    }
}
