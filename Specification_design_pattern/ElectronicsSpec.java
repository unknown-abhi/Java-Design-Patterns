
/**
 * Concrete specification that checks whether a product belongs to the
 * ELECTRONICS category.
 *
 * Demonstrates a simple category-based rule used in combination with other
 * specifications for filtering or discounting logic.
 */
public class ElectronicsSpec implements Specification<Product> {

    @Override
    public boolean isSatisfiedBy(Product product) {
        return "ELECTRONICS".equalsIgnoreCase(product.getCategory());
    }
}