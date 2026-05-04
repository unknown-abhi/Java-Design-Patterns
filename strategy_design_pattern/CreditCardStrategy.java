package strategy_design_pattern;

/**
 * Concrete Strategy for credit card payments.
 */
public class CreditCardStrategy implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid with credit card.");
    }

}
