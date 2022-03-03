package day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    OrderService orderService;

    Product p1;
    Product p2;
    Product p3;
    Product p4;
    Product p5;

    Order o1;
    Order o2;
    Order o3;
    Order o4;
    Order o5;

    @BeforeEach
    void setUp() {
        orderService = new OrderService();

        p1 = new Product("Tv", "IT", 2000);
        p2 = new Product("Laptop", "IT", 2400);
        p3 = new Product("Phone", "IT", 400);
        p4 = new Product("Lord of The Rings", "Book", 20);
        p5 = new Product("Harry Potter Collection", "Book", 120);

        o1 = new Order("pending", LocalDate.of(2021, 6, 7));
        o1.addProduct(p1);
        o1.addProduct(p2);
        o1.addProduct(p4);
        o1.addProduct(p5);

        o2 = new Order("on delivery", LocalDate.of(2021, 6, 1));
        o2.addProduct(p1);
        o2.addProduct(p3);
        o2.addProduct(p4);

        o3 = new Order("pending", LocalDate.of(2021, 6, 7));
        o3.addProduct(p2);
        o3.addProduct(p3);
        o3.addProduct(p4);

        o4 = new Order("on delivery", LocalDate.of(2021, 6, 1));
        o4.addProduct(p2);
        o4.addProduct(p3);
        o4.addProduct(p5);

        o5 = new Order("pending", LocalDate.of(2021, 6, 7));
        o5.addProduct(p4);
        o5.addProduct(p5);

        orderService.saveOrder(o1);
        orderService.saveOrder(o2);
        orderService.saveOrder(o3);
        orderService.saveOrder(o4);
        orderService.saveOrder(o5);
    }

    @Test
    void getOrdersTest() {
        assertEquals(new ArrayList<>(List.of(o1, o2, o3, o4, o5)), orderService.getOrders());
    }

    @Test
    void saveOrderTest() {
        orderService.saveOrder(o1);
        assertEquals(new ArrayList<>(List.of(o1, o2, o3, o4, o5, o1)), orderService.getOrders());
    }

    @Test
    void getOrdersByStatusTest() {
        assertEquals(new ArrayList<>(List.of(o1, o3, o5)), orderService.getOrdersByStatus("pending"));
    }

    @Test
    void getNumberOfOrdersByStatusTest() {
        assertEquals(2, orderService.getNumberOfOrdersByStatus("on delivery"));
    }

    @Test
    void getOrdersBetweenDatesTest() {
        assertEquals(
            new ArrayList<>(List.of(o2, o4)),
            orderService.getOrdersBetweenDates(LocalDate.of(2021, 5, 6), LocalDate.of(2021, 6, 5)));
    }

    @Test
    void isThereAnOrderWithLessProductsThenGivenTest() {
        assertTrue(orderService.isThereAnOrderWithLessProductsThenGiven(4));
        assertFalse(orderService.isThereAnOrderWithLessProductsThenGiven(2));
    }

    @Test
    void getOrderWithMaxProductsTest() {
        assertEquals(o1, orderService.getOrderWithMaxProducts());
    }

    @Test
    void getOrdersWithCategoryTest() {
        assertEquals(new ArrayList<>(List.of(o1, o2, o3, o4)), orderService.getOrdersWithCategory("IT"));
    }
}