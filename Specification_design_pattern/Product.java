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

    public double getPrice() {
        return price;
    }

    public boolean isInStock() {
        return inStock;
    }

    public String getCategory() {
        return category;
    }
}