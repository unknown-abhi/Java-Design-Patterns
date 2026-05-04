/**
 * Demonstrates the Decorator pattern using pizza toppings.
 */
public class MainApp {
    public static void main(String[] args) {
        Pizza pizza = new PlainPizza();
        System.out.println(pizza.getDescription() + " costs $" + pizza.getCost());

        pizza = new Cheese(pizza);
        pizza = new Olives(pizza);
        System.out.println(pizza.getDescription() + " costs $" + pizza.getCost());

        Pizza fancyPizza = new Olives(new Cheese(new PlainPizza()));
        System.out.println(fancyPizza.getDescription() + " costs $" + fancyPizza.getCost());
    }
}
