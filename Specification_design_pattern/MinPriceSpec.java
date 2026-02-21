
/**
 * Concrete specification that checks whether a product meets a minimum price.
 *
 * Used as a building block for composing more complex discount or validation
 * rules together with other specifications.
 */
public class MinPriceSpec implements Specification<Product> {

    @Override
    public boolean isSatisfiedBy(Product product) {
        return product.getPrice() >= 1000;
    }
}