package prototype_design_pattern;

public class NetworkConnection implements Cloneable {

    private String ipAddress;
    private int port;
    private String data;

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void loadVeryImpData() throws InterruptedException {
        this.data = "Heavy Imp Data";
        Thread.sleep(5000);
        System.out.println("Loading very important data...");
        System.out.println("Data loaded successfully.");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // Override the toString() method to print the network connection details
    @Override
    public String toString() {
        return "NetworkConnection [ipAddress=" + ipAddress + ", port=" + port + ", data=" + data + "]";
    }
}
