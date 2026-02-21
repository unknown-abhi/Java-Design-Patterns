
/**
 * Demonstration of the Specification design pattern.
 *
 * Constructs a composite specification by combining simple specifications
 * with and and evaluates the rule for a sample product.
 * 
 * This pattern comes from Domain-Driven Design by Eric Evans and is useful for
 * encapsulating complex business rules in a reusable and composable way.
 */
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