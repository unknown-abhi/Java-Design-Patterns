/**
 * Proxy that controls access to the real image and loads it lazily.
 */
public class ProxyImage implements Image {
    private final String fileName;
    private RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        System.out.println("Proxy delegating display request.");
        realImage.display();
    }
}
