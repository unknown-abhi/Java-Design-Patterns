package strategy_design_pattern;

public class CreditCardStrategy implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid with credit card.");
    }

}
