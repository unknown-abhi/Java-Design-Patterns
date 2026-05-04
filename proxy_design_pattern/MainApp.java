/**
 * Demonstrates the Proxy pattern with lazy-loading image access.
 */
public class MainApp {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_image.jpg");
        System.out.println("First access:");
        image.display();

        System.out.println();
        System.out.println("Second access:");
        image.display();
    }
}
