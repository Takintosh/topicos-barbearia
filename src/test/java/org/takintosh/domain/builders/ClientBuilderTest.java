package org.takintosh.domain.builders;

import org.junit.jupiter.api.Test;
import org.takintosh.domain.models.Client;
import static org.junit.jupiter.api.Assertions.*;

public class ClientBuilderTest {

    @Test
    public void testValidClientBuilder() {
        Client client = new ClientBuilder()
                .withCpf("123.456.789-01")
                .withName("John Doe")
                .withContact("+55 21 1234-5678")
                .withAge(25)
                .build();
        assertEquals("123.456.789-01", client.getCpf());
        assertEquals("John Doe", client.getName());
        assertEquals("+55 21 1234-5678", client.getContact());
        assertEquals(25, client.getAge());
    }

    @Test
    public void testInvalidCpfInBuilder() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new ClientBuilder()
                    .withCpf("12345678901")
                    .withName("John Doe")
                    .withContact("+55 21 1234-5678")
                    .withAge(25)
                    .build();
        });
        assertEquals("Invalid CPF format", exception.getMessage());
    }

    @Test
    public void testInvalidNameInBuilder() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new ClientBuilder()
                    .withCpf("123.456.789-01")
                    .withName("")
                    .withContact("+55 21 1234-5678")
                    .withAge(25)
                    .build();
        });
        assertEquals("Name cannot be empty", exception.getMessage());
    }

    @Test
    public void testInvalidPhoneBrazilInBuilder() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new ClientBuilder()
                    .withCpf("123.456.789-00")
                    .withName("John Doe")
                    .withContact("+55119999999") // Invalid phone length
                    .withAge(25)
                    .build();
        });
        assertEquals("Invalid contact format. Must be a valid phone number for Brazil or Uruguay.", exception.getMessage());
    }

    @Test
    public void testInvalidPhoneUruguayInBuilder() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new ClientBuilder()
                    .withCpf("123.456.789-00")
                    .withName("John Doe")
                    .withContact("+59812345") // Invalid phone length
                    .withAge(25)
                    .build();
        });
        assertEquals("Invalid contact format. Must be a valid phone number for Brazil or Uruguay.", exception.getMessage());
    }

    @Test
    public void testInvalidAgeInBuilder() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new ClientBuilder()
                    .withCpf("123.456.789-01")
                    .withName("John Doe")
                    .withContact("+55 21 1234-5678")
                    .withAge(17)
                    .build();
        });
        assertEquals("Age must be at least 18", exception.getMessage());
    }

}