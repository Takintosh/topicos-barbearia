package org.takintosh.domain.builders;

import org.takintosh.domain.models.Barber;

import java.util.List;

public class BarberBuilder {
    private int id;
    private String name;
    private String schedules;

    public BarberBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public BarberBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public BarberBuilder withSchedules(String schedules) {
        this.schedules = schedules;
        return this;
    }

    public Barber build() {
        return new Barber(id, name, schedules);
    }
}