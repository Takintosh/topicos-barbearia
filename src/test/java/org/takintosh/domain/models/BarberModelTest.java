package org.takintosh.domain.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BarberModelTest {

    @Test
    public void testValidBarber() {
        Barber barber = new Barber("Jane Smith", "09:00-17:00");
        barber.setId(1);
        assertEquals(1, barber.getId());
        assertEquals("Jane Smith", barber.getName());
        assertEquals("09:00-17:00", barber.getSchedules());
    }

    @Test
    public void testInvalidId() {
        Barber barber = new Barber("Jane Smith", "09:00-17:00");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            barber.setId(0); // Invalid ID
        });
        assertEquals("ID must be greater than 0", exception.getMessage());
    }

    @Test
    public void testSetterInvalidName() {
        Barber barber = new Barber("Jane Smith", "09:00-17:00");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            barber.setName(""); // Invalid name
        });
        assertEquals("Name cannot be empty", exception.getMessage());
    }

    @Test
    public void testSetterInvalidSchedules() {
        Barber barber = new Barber("Jane Smith", "09:00-17:00");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            barber.setSchedules(""); // Invalid schedules
        });
        assertEquals("Schedules cannot be empty", exception.getMessage());
    }

}