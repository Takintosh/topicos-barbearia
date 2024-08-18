package org.takintosh.domain.builders;

import org.junit.jupiter.api.Test;
import org.takintosh.domain.models.Appointment;
import org.takintosh.domain.models.Barber;
import org.takintosh.domain.models.Client;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentBuilderTest {

    @Test
    public void testValidAppointmentBuilder() {
        Client client = new ClientBuilder()
                .withCpf("123.456.789-00")
                .withName("John Doe")
                .withContact("+5511999999999")
                .withAge(25)
                .build();

        Barber barber = new BarberBuilder()
                .withName("Jane Smith")
                .withSchedules("09:00-17:00")
                .build();

        Appointment appointment = new AppointmentBuilder()
                .withDate(LocalDateTime.now())
                .withClient(client)
                .withBarber(barber)
                .build();

        assertNotNull(appointment.getDate());
        assertEquals(client, appointment.getClient());
        assertEquals(barber, appointment.getBarber());
    }

    @Test
    public void testMissingClientInBuilder() {
        Barber barber = new BarberBuilder()
                .withName("Jane Smith")
                .withSchedules("09:00-17:00")
                .build();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new AppointmentBuilder()
                    .withDate(LocalDateTime.now())
                    .withBarber(barber)
                    .build();
        });
        assertEquals("Client is required", exception.getMessage());
    }

    @Test
    public void testMissingBarberInBuilder() {
        Client client = new ClientBuilder()
                .withCpf("123.456.789-00")
                .withName("John Doe")
                .withContact("+5511999999999")
                .withAge(25)
                .build();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new AppointmentBuilder()
                    .withDate(LocalDateTime.now())
                    .withClient(client)
                    .build();
        });
        assertEquals("Barber is required", exception.getMessage());
    }

    @Test
    public void testMissingDateInBuilder() {
        Client client = new ClientBuilder()
                .withCpf("123.456.789-00")
                .withName("John Doe")
                .withContact("+5511999999999")
                .withAge(25)
                .build();
        Barber barber = new BarberBuilder()
                .withName("Jane Smith")
                .withSchedules("09:00-17:00")
                .build();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new AppointmentBuilder()
                    .withClient(client)
                    .withBarber(barber)
                    .build();
        });
        assertEquals("Date is required", exception.getMessage());
    }

}