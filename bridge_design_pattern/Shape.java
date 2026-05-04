/**
 * Abstraction class that holds a reference to the Color implementor.
 * This is the BRIDGE - it separates shape abstraction from color
 * implementation.
 * Different shapes can use different colors without tight coupling.
 */
public abstract class Shape {
    // The bridge - holds reference to the Color implementor
    protected Color color;

    // Constructor accepts a Color implementor
    public Shape(Color color) {
        this.color = color; // Bridge connects abstraction with implementation
    }

    // Abstract method to be implemented by concrete shapes
    abstract public void draw();
}
