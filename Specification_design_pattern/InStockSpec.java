public class InStockSpec implements Specification<Product> {

    @Override
    public boolean isSatisfiedBy(Product product) {
        return product.isInStock();
    }
}