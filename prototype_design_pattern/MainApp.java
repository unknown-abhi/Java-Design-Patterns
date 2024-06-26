package prototype_design_pattern;

public class MainApp {

    public static void main(String[] args) throws InterruptedException {

        NetworkConnection netConnection = new NetworkConnection();

        netConnection.setIpAddress("127.0.0.1");
        netConnection.setPort(8080);
        netConnection.loadVeryImpData();

        System.out.println(netConnection);

        try {
            NetworkConnection netConnectionClone = (NetworkConnection) netConnection.clone();

            netConnection.getDomains().remove(0);
            System.out.println(netConnection);
            System.out.println("Clone : " + netConnectionClone);
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}