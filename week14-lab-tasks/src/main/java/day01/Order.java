package day01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {

    // --- attributes ---------------------------------------------------------

    private String status;
    private LocalDate orderDate;
    private List<Product> products = new ArrayList<>();

    // --- constructors -------------------------------------------------------

    public Order(String status, LocalDate orderDate) {
        this.status = status;
        this.orderDate = orderDate;
    }

    // --- getters and setters ------------------------------------------------

    public String getStatus() { return status; }
    public LocalDate getOrderDate() { return orderDate; }
    public List<Product> getProducts() { return products; }

    // --- public methods -----------------------------------------------------

    public void addProduct(Product product) {
        products.add(product);
    }
}