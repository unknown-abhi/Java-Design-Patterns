
/**
 * Domain model used by the Specification examples.
 *
 * Contains a few simple properties (name, price, stock flag and category)
 * that concrete specifications inspect when evaluating business rules.
 */
public class Product {

    private String name;
    private double price;
    private boolean inStock;
    private String category;

    public Product(String name, double price, boolean inStock, String category) {
        this.name = name;
        this.price = price;
        this.inStock = inStock;
        this.category = category;
    }

    /** Return the product price used by price-based specifications. */
    public double getPrice() {
        return price;
    }

    /** Return true when the product is currently available in stock. */
    public boolean isInStock() {
        return inStock;
    }

    /** Return the product category used by category-based specifications. */
    public String getCategory() {
        return category;
    }
}