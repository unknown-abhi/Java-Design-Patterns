package strategy_design_pattern;

/**
 * Strategy interface for payment methods.
 */
public interface PaymentStrategy {
    public void pay(int amount);
}
