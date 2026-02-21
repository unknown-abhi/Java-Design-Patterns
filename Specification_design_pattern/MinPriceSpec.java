public class MinPriceSpec implements Specification<Product> {

    @Override
    public boolean isSatisfiedBy(Product product) {
        return product.getPrice() >= 1000;
    }
}