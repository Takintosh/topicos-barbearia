package org.takintosh.domain.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClientModelTest {

    @Test
    public void testValidClient() {
        Client client = new Client("123.456.789-01", "John Doe", "+55 21 1234-5678", 25);
        assertEquals("123.456.789-01", client.getCpf());
        assertEquals("John Doe", client.getName());
        assertEquals("+55 21 1234-5678", client.getContact());
        assertEquals(25, client.getAge());
    }

    @Test
    public void testSetterInvalidCpf() {
        Client client = new Client("123.456.789-01", "John Doe", "+55 21 1234-5678", 25);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            client.setCpf("12345678901");
        });
        assertEquals("Invalid CPF format", exception.getMessage());
    }

    @Test
    public void testSetterInvalidName() {
        Client client = new Client("123.456.789-01", "John Doe", "+55 21 1234-5678", 25);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            client.setName("");
        });
        assertEquals("Name cannot be empty", exception.getMessage());
    }

    @Test
    public void testSetterInvalidContact() {
        Client client = new Client("123.456.789-01", "John Doe", "+55 21 1234-5678", 25);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            client.setContact("");
        });
        assertEquals("Contact cannot be empty", exception.getMessage());
    }

    @Test
    public void testSetterInvalidAge() {
        Client client = new Client("123.456.789-01", "John Doe", "+55 21 1234-5678", 25);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            client.setAge(17);
        });
        assertEquals("Age must be at least 18", exception.getMessage());
    }

}