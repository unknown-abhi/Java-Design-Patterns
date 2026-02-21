

public class Main {

    public static void main(String[] args) {

        Product laptop = new Product("Laptop", 50000, true, "ELECTRONICS");

        Specification<Product> discountRule = new MinPriceSpec()
                .and(new InStockSpec())
                .and(new ElectronicsSpec());

        if (discountRule.isSatisfiedBy(laptop)) {
            System.out.println("Discount allowed");
        } else {
            System.out.println("No discount");
        }
    }
}