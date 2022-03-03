package day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    Order order;
    Product productA;
    Product productB;

    @BeforeEach
    void setUp() {
        order = new Order("First status", LocalDate.of(2022, 1, 10));
        productA = new Product("Product A", "First category", 1000);
        productB = new Product("Product B", "First category", 2000);
    }

    @Test
    void getStatusTest() {
        assertEquals("First status", order.getStatus());
    }

    @Test
    void getOrderDateTest() {
        assertEquals(LocalDate.of(2022, 1, 10), order.getOrderDate());
    }

    @Test
    void getProductsTest() {
        assertEquals(new ArrayList<>(), order.getProducts());
    }

    @Test
    void addProductTest() {
        order.addProduct(productA);
        order.addProduct(productB);

        assertEquals(new ArrayList<>(List.of(productA, productB)), order.getProducts());
    }
}