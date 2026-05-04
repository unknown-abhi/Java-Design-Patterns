/**
 * Refined abstraction for circle shape.
 * Extends the Shape abstraction and provides circle-specific behavior.
 */
public class Circle extends Shape {
    // Constructor accepts a Color implementor via the bridge
    public Circle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        // Uses the color implementor through the bridge
        // Circle behavior is independent of color implementation
        System.out.println("Drawing circle: " + color.applyColor());
    }
}
