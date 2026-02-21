
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

        Product laptop = new Product("Laptop", 5000, true, "ELECTRONICS");

        Specification<Product> discountRule = new MinPriceSpec()
                .and(new InStockSpec())
                .and(new ElectronicsSpec());

        // What you just achieved:
        // Instead of writing:
        /// if (price >= 1000 && inStock && category.equals("ELECTRONICS"))
        // you encapsulated each condition as a Specification and composed them.

        if (discountRule.isSatisfiedBy(laptop)) {
            System.out.println("Discount allowed");
        } else {
            System.out.println("No discount");
        }
    }
}