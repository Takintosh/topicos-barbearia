package org.takintosh.domain.models;

import java.util.List;

public class Barber {
    private Long id;
    private String name;
    private List<String> schedules;

    public Barber(Long id, String name, List<String> schedules) {
        this.id = id;
        this.name = name;
        this.schedules = schedules;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSchedules() {
        return schedules;
    }
    public void setSchedules(List<String> schedules) {
        this.schedules = schedules;
    }
}
