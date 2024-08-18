package org.takintosh.domain.builders;

import org.junit.jupiter.api.Test;
import org.takintosh.domain.models.Barber;
import static org.junit.jupiter.api.Assertions.*;

public class BarberBuilderTest {

    @Test
    public void testValidBarberBuilder() {
        Barber barber = new BarberBuilder()
                .withName("Jane Smith")
                .withSchedules("09:00-17:00")
                .build();
        barber.setId(1);
        assertEquals(1, barber.getId());
        assertEquals("Jane Smith", barber.getName());
        assertEquals("09:00-17:00", barber.getSchedules());
    }

    @Test
    public void testInvalidNameInBuilder() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new BarberBuilder()
                    .withName("")
                    .withSchedules("09:00-17:00")
                    .build();
        });
        assertEquals("Name cannot be empty", exception.getMessage());
    }

    @Test
    public void testInvalidSchedulesInBuilder() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new BarberBuilder()
                    .withName("Jane Smith")
                    .withSchedules("")
                    .build();
        });
        assertEquals("Schedules cannot be empty", exception.getMessage());
    }

    @Test
    public void testInvalidSchedulesFormatInBuilder() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new BarberBuilder()
                    .withName("Jane Smith")
                    .withSchedules("25:00-30:00")
                    .build();
        });
        assertEquals("Invalid schedules format", exception.getMessage());
    }

}