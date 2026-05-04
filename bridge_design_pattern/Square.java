/**
 * Refined abstraction for square shape.
 * Extends the Shape abstraction and provides square-specific behavior.
 */
public class Square extends Shape {
    // Constructor accepts a Color implementor via the bridge
    public Square(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        // Uses the color implementor through the bridge
        // Square behavior is independent of color implementation
        System.out.println("Drawing square: " + color.applyColor());
    }
}
