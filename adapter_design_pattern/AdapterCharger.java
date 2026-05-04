package adapter_design_pattern;

/**
 * Adapter that wraps an Android charger into the IphoneAdapter interface.
 */
public class AdapterCharger implements IphoneAdapter {

    private AndroidAdapter androidAdapter;

    public AdapterCharger(AndroidAdapter androidAdapter) {
        this.androidAdapter = androidAdapter;
    }

    @Override
    public String chargeIphone() {
        System.out.println("Charging With Adapter");
        return androidAdapter.chargeAndroid();
    }
}
