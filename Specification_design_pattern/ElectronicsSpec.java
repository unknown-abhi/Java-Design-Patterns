
public class ElectronicsSpec implements Specification<Product> {

    @Override
    public boolean isSatisfiedBy(Product product) {
        return "ELECTRONICS".equalsIgnoreCase(product.getCategory());
    }
}