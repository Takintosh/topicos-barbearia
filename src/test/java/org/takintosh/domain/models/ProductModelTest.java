package org.takintosh.domain.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductModelTest {

    @Test
    public void testIncreaseQuantity() {
        Product product = new Product("Shampoo", 10.0, 0.2, 5);
        product.increaseQuantity(3);
        assertEquals(8, product.getQuantity());
    }

    @Test
    public void testDecreaseQuantity() {
        Product product = new Product("Shampoo", 10.0, 0.2, 5);
        product.decreaseQuantity(2);
        assertEquals(3, product.getQuantity());
    }

    @Test
    public void testDecreaseQuantityBelowZero() {
        Product product = new Product("Shampoo", 10.0, 0.2, 5);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            product.decreaseQuantity(10);
        });
        assertEquals("Not enough quantity in stock.", exception.getMessage());
    }

    @Test
    public void testIncreaseQuantityNegativeAmount() {
        Product product = new Product("Shampoo", 10.0, 0.2, 5);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            product.increaseQuantity(-3);
        });
        assertEquals("Amount to increase cannot be negative", exception.getMessage());
    }

    @Test
    public void testDecreaseQuantityNegativeAmount() {
        Product product = new Product("Shampoo", 10.0, 0.2, 5);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            product.decreaseQuantity(-3);
        });
        assertEquals("Amount to decrease cannot be negative", exception.getMessage());
    }

}