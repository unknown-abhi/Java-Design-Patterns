package adapter_design_pattern;

/**
 * Concrete Android charger implementation.
 */
public class AndroidAdapterImpl implements AndroidAdapter {

    @Override
    public String chargeAndroid() {
        return "Android Charger";
    }
}