package org.takintosh.domain.models;

import java.util.List;

public class Barber {
    private int id;
    private String name;
    private String schedules;

    public Barber(int id, String name, String schedules) {
        this.id = id;
        this.name = name;
        this.schedules = schedules;
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

    public String getSchedules() {
        return schedules;
    }
    public void setSchedules(String schedules) {
        this.schedules = schedules;
    }
}
