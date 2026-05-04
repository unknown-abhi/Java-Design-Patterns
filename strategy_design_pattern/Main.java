package strategy_design_pattern;

/**
 * Demonstrates the Strategy pattern with payment strategies.
 */
public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new CreditCardStrategy());
        context.pay(100);

        context.setPaymentStrategy(new PayPalStrategy());
        context.pay(200);
    }
}