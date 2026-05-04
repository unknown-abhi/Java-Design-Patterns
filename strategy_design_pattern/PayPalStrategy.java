package strategy_design_pattern;

/**
 * Concrete Strategy for PayPal payments.
 */
public class PayPalStrategy implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println("Paying using PayPal: $" + amount);
    }
}
