package adapter_design_pattern;

public class Iphone {

    public void charge(IphoneAdapter adapter) {
        System.out.println(adapter.chargeIphone());
    }
}
