
/**
 * Concrete specification that checks whether a product is available in stock.
 *
 * Can be combined with other specifications to ensure availability and
 * additional business constraints (price, category, etc.).
 */
public class InStockSpec implements Specification<Product> {

    @Override
    public boolean isSatisfiedBy(Product product) {
        return product.isInStock();
    }
}