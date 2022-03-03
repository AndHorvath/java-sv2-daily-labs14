package day01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrderService {

    // --- attributes ---------------------------------------------------------

    private List<Order> orders;

    // --- constructors -------------------------------------------------------

    public OrderService() {
        orders = new ArrayList<>();
    }

    // --- getters and setters ------------------------------------------------

    public List<Order> getOrders() { return orders; }

    // --- public methods -----------------------------------------------------

    public void saveOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrdersByStatus(String status) {
        return orders.stream().filter(order -> order.getStatus().equals(status)).toList();
    }

    public int getNumberOfOrdersByStatus(String status) {
        return (int) orders.stream().filter(order -> order.getStatus().equals(status)).count();
    }

    public List<Order> getOrdersBetweenDates(LocalDate dateA, LocalDate dateB) {
        return orders.stream()
            .filter(order -> order.getOrderDate().isAfter(dateA))
            .filter(order -> order.getOrderDate().isBefore(dateB))
            .toList();
    }

    public boolean isThereAnOrderWithLessProductsThenGiven(int products) {
        return orders.stream().anyMatch(order -> order.getProducts().size() < products);
    }

    public Order getOrderWithMaxProducts() {
        return orders.stream()
            .max(Comparator.comparingInt(order -> order.getProducts().size()))
            .orElseThrow(() -> new IllegalStateException("Empty list."));
    }

    public List<Order> getOrdersWithCategory(String category) {
        return orders.stream()
            .filter(
                order ->
                order.getProducts().stream().anyMatch(product -> product.getCategory().equals(category)))
            .toList();
    }
}