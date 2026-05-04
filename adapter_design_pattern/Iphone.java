package adapter_design_pattern;

/**
 * Client class that uses an IphoneAdapter to charge an iPhone.
 */
public class Iphone {

    public void charge(IphoneAdapter adapter) {
        System.out.println(adapter.chargeIphone());
    }
}
