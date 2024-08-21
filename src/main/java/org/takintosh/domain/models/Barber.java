package org.takintosh.domain.models;

import org.takintosh.domain.strategies.*;

public class Barber {
    private Integer id;
    private String name;
    private String schedules;
    private int numberOfCuts;
    private CommissionStrategy commissionStrategy;

    public Barber(String name, String schedules) {
        // Validate name
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        // Validate schedules
        if (schedules == null || schedules.isEmpty()) {
            throw new IllegalArgumentException("Schedules cannot be empty");
        }
        // Validate schedules format
        if (!schedules.matches("\\d{2}:\\d{2}-\\d{2}:\\d{2}")) {
            throw new IllegalArgumentException("Invalid schedules format");
        }

        this.name = name;
        this.schedules = schedules;
    }

    // Commission Strategy
    private void setCommissionStrategy() {
        if (numberOfCuts >= 1 && numberOfCuts <= 2) {
            this.commissionStrategy = new NoBonusCommission();
        } else if (numberOfCuts >= 3 && numberOfCuts <= 5) {
            this.commissionStrategy = new OnePercentBonusCommission();
        } else if (numberOfCuts > 6) {
            this.commissionStrategy = new FivePercentBonusCommission();
        }
    }

    public double calculateCommission(double baseCommission) {
        return commissionStrategy.calculateCommission(baseCommission);
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be greater than 0");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public String getSchedules() {
        return schedules;
    }
    public void setSchedules(String schedules) {
        if (schedules == null || schedules.isEmpty()) {
            throw new IllegalArgumentException("Schedules cannot be empty");
        }
        if (!schedules.matches("\\d{2}:\\d{2}-\\d{2}:\\d{2}")) {
            throw new IllegalArgumentException("Invalid schedules format");
        }
        this.schedules = schedules;
    }
}
