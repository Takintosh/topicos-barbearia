package org.takintosh.domain.builders;

import org.takintosh.domain.models.Barber;

import java.util.List;

public class BarberBuilder {
    private Long id;
    private String name;
    private List<String> schedules;

    public BarberBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public BarberBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public BarberBuilder withSchedules(List<String> schedules) {
        this.schedules = schedules;
        return this;
    }

    public Barber build() {
        return new Barber(id, name, schedules);
    }
}