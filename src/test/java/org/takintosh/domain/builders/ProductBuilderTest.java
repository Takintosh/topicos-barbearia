package org.takintosh.domain.builders;

import org.junit.jupiter.api.Test;
import org.takintosh.domain.models.Product;

import static org.junit.jupiter.api.Assertions.*;

public class ProductBuilderTest {

    @Test
    public void testValidProduct() {
        Product product = new ProductBuilder()
                .withName("Shampoo")
                .withPrice(10.0)
                .withCommission(0.2)
                .withQuantity(5)
                .build();

        assertEquals("Shampoo", product.getName());
        assertEquals(10.0, product.getPrice());
        assertEquals(0.2, product.getCommission());
        assertEquals(5, product.getQuantity());
    }

    @Test
    public void testInvalidCommission() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new ProductBuilder()
                    .withName("Shampoo")
                    .withPrice(10.0)
                    .withCommission(-0.5)
                    .withQuantity(5)
                    .build();
        });
        assertEquals("Commission must be between 0 and 1", exception.getMessage());
    }

    @Test
    public void testInvalidPrice() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new ProductBuilder()
                    .withName("Shampoo")
                    .withPrice(-10.0)
                    .withCommission(0.2)
                    .withQuantity(5)
                    .build();
        });
        assertEquals("Price must be greater than 0", exception.getMessage());
    }

}