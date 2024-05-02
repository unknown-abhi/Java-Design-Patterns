package prototype_design_pattern;

import java.util.ArrayList;
import java.util.List;

public class NetworkConnection implements Cloneable {

    private String ipAddress;
    private int port;
    private String data;
    private List<String> domains = new ArrayList<>();

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

    public List<String> getDomains() {
        return domains;
    }

    public void setDomains(List<String> domains) {
        this.domains = domains;
    }

    public void loadVeryImpData() throws InterruptedException {
        setData("Heavy Imp Data");

        this.domains.add("dev.com");
        this.domains.add("google.com");
        this.domains.add("facebook.com");

        Thread.sleep(2000);
        System.out.println("Loading very important data...");
        System.out.println("Data loaded successfully.");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        // logic for cloning - Deep Copy
        NetworkConnection networkConnection = new NetworkConnection();
        networkConnection.setIpAddress(this.ipAddress);
        networkConnection.setPort(this.port);
        networkConnection.setData(this.data);

        for (String d : this.getDomains()) {
            networkConnection.getDomains().add(d);
        }
        // return super.clone(); // Shallow Copy
        return networkConnection;
    }

    // Override the toString() method to print the network connection details
    @Override
    public String toString() {
        return "NetworkConnection [ipAddress=" + ipAddress + ", port=" + port + ", data=" + data + ", domains="
                + domains + "]";
    }
}
