package org.takintosh.domain.models;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentModelTest {

    @Test
    public void testValidAppointment() {
        Client client = new Client("123.456.789-00", "John Doe", "+5511999999999", 25);
        Barber barber = new Barber("Jane Smith", "09:00-17:00");
        LocalDateTime date = LocalDateTime.now();

        Appointment appointment = new Appointment(date, client, barber);
        appointment.setId(1);

        assertEquals(1, appointment.getId());
        assertEquals(date, appointment.getDate());
        assertEquals(client, appointment.getClient());
        assertEquals(barber, appointment.getBarber());
    }

    @Test
    public void testInvalidId() {
        Client client = new Client("123.456.789-00", "John Doe", "+5511999999999", 25);
        Barber barber = new Barber("Jane Smith", "09:00-17:00");
        LocalDateTime date = LocalDateTime.now();

        Appointment appointment = new Appointment(date, client, barber);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            appointment.setId(0); // Invalid ID
        });
        assertEquals("ID must be greater than 0", exception.getMessage());
    }

    @Test
    public void testMissingClient() {
        Barber barber = new Barber("Jane Smith", "09:00-17:00");
        LocalDateTime date = LocalDateTime.now();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(date, null, barber); // Missing client
        });
        assertEquals("Client is required", exception.getMessage());
    }

    @Test
    public void testMissingBarber() {
        Client client = new Client("123.456.789-00", "John Doe", "+5511999999999", 25);
        LocalDateTime date = LocalDateTime.now();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(date, client, null); // Missing barber
        });
        assertEquals("Barber is required", exception.getMessage());
    }

    @Test
    public void testInvalidDate() {
        Client client = new Client("123.456.789-00", "John Doe", "+5511999999999", 25);
        Barber barber = new Barber("Jane Smith", "09:00-17:00");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, client, barber); // Missing date
        });
        assertEquals("Date is required", exception.getMessage());
    }

}