package adapter_design_pattern;

/**
 * Direct iPhone charger implementation used when no adapter is needed.
 */
public class IphoneAdapterImpl implements IphoneAdapter {

    @Override
    public String chargeIphone() {
        return "Iphone Charger";
    }

}
