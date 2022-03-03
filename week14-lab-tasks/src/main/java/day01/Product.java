package day01;

public class Product {

    // --- attributes ---------------------------------------------------------

    private String name;
    private String category;
    private double price;

    // --- constructors -------------------------------------------------------

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // --- getters and setters ------------------------------------------------

    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
}