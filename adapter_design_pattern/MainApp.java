package adapter_design_pattern;

/**
 * Demonstrates the Adapter pattern by charging an iPhone through an Android
 * adapter.
 */
public class MainApp {
    public static void main(String[] args) {

        // IphoneAdapter iphoneAdapter = new IphoneAdapterImpl();
        IphoneAdapter iphoneAdapter = new AdapterCharger(new AndroidAdapterImpl());

        Iphone iphone = new Iphone();

        iphone.charge(iphoneAdapter);
    }
}