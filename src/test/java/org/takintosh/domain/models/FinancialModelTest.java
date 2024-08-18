package org.takintosh.domain.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FinancialModelTest {

    @Test
    public void testValidFinancial() {
        Client client = new Client("123.456.789-00", "John Doe", "+5511999999999", 25);
        Barber barber = new Barber("Jane Smith", "09:00-17:00");
        Product product = new Product("Shampoo", 10.0, 0.2, 5);

        Financial financial = new Financial(100.0, product, barber, client);
        financial.setId(1);

        assertEquals(1, financial.getId());
        assertEquals(100.0, financial.getSaleValue());
        assertEquals(product, financial.getProduct());
        assertEquals(barber, financial.getBarber());
        assertEquals(client, financial.getClient());
    }

    @Test
    public void testInvalidId() {
        Client client = new Client("123.456.789-00", "John Doe", "+5511999999999", 25);
        Barber barber = new Barber("Jane Smith", "09:00-17:00");
        Product product = new Product("Shampoo", 10.0, 0.2, 5);

        Financial financial = new Financial(100.0, product, barber, client);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            financial.setId(0); // Invalid ID
        });
        assertEquals("ID must be greater than 0", exception.getMessage());
    }

    @Test
    public void testInvalidSaleValue() {
        Client client = new Client("123.456.789-00", "John Doe", "+5511999999999", 25);
        Barber barber = new Barber("Jane Smith", "09:00-17:00");
        Product product = new Product("Shampoo", 10.0, 0.2, 5);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Financial(-10.0, product, barber, client); // Invalid sale value
        });
        assertEquals("Sale value must be greater than 0", exception.getMessage());
    }

    @Test
    public void testSetterInvalidSaleValue() {
        Client client = new Client("123.456.789-00", "John Doe", "+5511999999999", 25);
        Barber barber = new Barber("Jane Smith", "09:00-17:00");
        Product product = new Product("Shampoo", 10.0, 0.2, 5);

        Financial financial = new Financial(100.0, product, barber, client);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            financial.setSaleValue(0); // Invalid sale value
        });
        assertEquals("Sale value must be greater than 0", exception.getMessage());
    }

    @Test
    public void testMissingProduct() {
        Client client = new Client("123.456.789-00", "John Doe", "+5511999999999", 25);
        Barber barber = new Barber("Jane Smith", "09:00-17:00");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Financial(100.0, null, barber, client); // Missing product
        });
        assertEquals("Product is required", exception.getMessage());
    }

    @Test
    public void testMissingBarber() {
        Client client = new Client("123.456.789-00", "John Doe", "+5511999999999", 25);
        Product product = new Product("Shampoo", 10.0, 0.2, 5);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Financial(100.0, product, null, client); // Missing barber
        });
        assertEquals("Barber is required", exception.getMessage());
    }

    @Test
    public void testMissingClient() {
        Barber barber = new Barber("Jane Smith", "09:00-17:00");
        Product product = new Product("Shampoo", 10.0, 0.2, 5);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Financial(100.0, product, barber, null); // Missing client
        });
        assertEquals("Client is required", exception.getMessage());
    }

}