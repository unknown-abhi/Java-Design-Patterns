/**
 * Demonstrates the Bridge pattern by combining shapes with different colors.
 * The Bridge pattern decouples shape abstraction from color implementation,
 * allowing them to vary independently without creating a large class hierarchy.
 */
public class MainApp {
    public static void main(String[] args) {
        // Create implementors (color implementations)
        Color redColor = new RedColor();
        Color blueColor = new BlueColor();

        // Create abstractions with different implementors
        // This shows how shapes can be combined with any color
        Shape redCircle = new Circle(redColor); // Circle with red
        Shape blueCircle = new Circle(blueColor); // Circle with blue
        Shape redSquare = new Square(redColor); // Square with red
        Shape blueSquare = new Square(blueColor); // Square with blue

        // Draw all combinations - demonstrates flexibility of bridge pattern
        redCircle.draw(); // Output: Drawing circle: Applying red color
        blueCircle.draw(); // Output: Drawing circle: Applying blue color
        redSquare.draw(); // Output: Drawing square: Applying red color
        blueSquare.draw(); // Output: Drawing square: Applying blue color

        // Benefits:
        // 1. New shapes can be added without modifying color implementations
        // 2. New colors can be added without modifying shape implementations
        // 3. Avoids the exponential class hierarchy (e.g., RedCircle, BlueCircle, etc.)
    }
}
