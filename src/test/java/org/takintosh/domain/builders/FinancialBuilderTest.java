package org.takintosh.domain.builders;

import org.junit.jupiter.api.Test;
import org.takintosh.domain.models.Barber;
import org.takintosh.domain.models.Client;
import org.takintosh.domain.models.Financial;
import org.takintosh.domain.models.Product;

import static org.junit.jupiter.api.Assertions.*;

public class FinancialBuilderTest {

    @Test
    public void testValidFinancialBuilder() {
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
        Product product = new ProductBuilder()
                .withName("Shampoo")
                .withPrice(10.0)
                .withCommission(0.2)
                .withQuantity(5)
                .build();

        Financial financial = new FinancialBuilder()
                .withSaleValue(100.0)
                .withProduct(product)
                .withBarber(barber)
                .withClient(client)
                .build();

        financial.setId(1);
        assertEquals(1, financial.getId());
        assertEquals(100.0, financial.getSaleValue());
        assertEquals(product, financial.getProduct());
        assertEquals(barber, financial.getBarber());
        assertEquals(client, financial.getClient());
    }

    @Test
    public void testInvalidSaleValueInBuilder() {
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
        Product product = new ProductBuilder()
                .withName("Shampoo")
                .withPrice(10.0)
                .withCommission(0.2)
                .withQuantity(5)
                .build();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new FinancialBuilder()
                    .withSaleValue(-10.0)
                    .withProduct(product)
                    .withBarber(barber)
                    .withClient(client)
                    .build();
        });
        assertEquals("Sale value must be greater than 0", exception.getMessage());
    }

    @Test
    public void testMissingProductInBuilder() {
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
            new FinancialBuilder()
                    .withSaleValue(100.0)
                    .withBarber(barber)
                    .withClient(client)
                    .build();
        });
        assertEquals("Product is required", exception.getMessage());
    }

    @Test
    public void testMissingBarberInBuilder() {
        Client client = new ClientBuilder()
                .withCpf("123.456.789-00")
                .withName("John Doe")
                .withContact("+5511999999999")
                .withAge(25)
                .build();
        Product product = new ProductBuilder()
                .withName("Shampoo")
                .withPrice(10.0)
                .withCommission(0.2)
                .withQuantity(5)
                .build();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new FinancialBuilder()
                    .withSaleValue(100.0)
                    .withProduct(product)
                    .withClient(client)
                    .build();
        });
        assertEquals("Barber is required", exception.getMessage());
    }

    @Test
    public void testMissingClientInBuilder() {
        Barber barber = new BarberBuilder()
                .withName("Jane Smith")
                .withSchedules("09:00-17:00")
                .build();
        Product product = new ProductBuilder()
                .withName("Shampoo")
                .withPrice(10.0)
                .withCommission(0.2)
                .withQuantity(5)
                .build();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new FinancialBuilder()
                    .withSaleValue(100.0)
                    .withProduct(product)
                    .withBarber(barber)
                    .build();
        });
        assertEquals("Client is required", exception.getMessage());
    }

}