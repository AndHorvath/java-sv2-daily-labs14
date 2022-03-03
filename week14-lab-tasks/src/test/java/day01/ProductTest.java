package day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product product;

    @BeforeEach
    void setUp() {
        product = new Product("Product", "First category", 1000);
    }

    @Test
    void getNameTest() {
        assertEquals("Product", product.getName());
    }

    @Test
    void getCategoryTest() {
        assertEquals("First category", product.getCategory());
    }

    @Test
    void getPriceTest() {
        assertEquals(1000, product.getPrice());
    }
}