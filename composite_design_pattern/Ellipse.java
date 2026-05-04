/**
 * Leaf node representing a simple graphic element.
 */
public class Ellipse implements Graphic {
    private final String name;

    public Ellipse(String name) {
        this.name = name;
    }

    @Override
    public void draw(String indent) {
        System.out.println(indent + "Ellipse: " + name);
    }
}
