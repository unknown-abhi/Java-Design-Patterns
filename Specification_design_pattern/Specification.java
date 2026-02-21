/**
 * Specification<T> — a functional contract for the Specification design
 * pattern.
 *
 * This interface represents a business rule (predicate) that can be tested
 * against domain objects of type T. It provides combinator default methods
 * to build complex rules from simple specifications: and, or and not.
 *
 * Example usage:
 * Specification<Product> rule = new MinPriceSpec().and(new InStockSpec());
 * boolean allowed = rule.isSatisfiedBy(product);
 */
public interface Specification<T> {

    /** Test whether the given object satisfies this specification. */
    boolean isSatisfiedBy(T t);

    /** Compose this specification with another using logical AND. */
    default Specification<T> and(Specification<T> other) {
        return t -> this.isSatisfiedBy(t) && other.isSatisfiedBy(t);
    }

    /** Compose this specification with another using logical OR. */
    default Specification<T> or(Specification<T> other) {
        return t -> this.isSatisfiedBy(t) || other.isSatisfiedBy(t);
    }

    /** Negate this specification. */
    default Specification<T> not() {
        return t -> !this.isSatisfiedBy(t);
    }
}