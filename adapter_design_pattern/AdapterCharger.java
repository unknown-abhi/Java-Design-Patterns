package adapter_design_pattern;

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
