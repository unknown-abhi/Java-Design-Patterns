import java.util.ArrayList;
import java.util.List;

/**
 * Composite node that can contain child Graphic elements.
 */
public class CompositeGraphic implements Graphic {
    private final String name;
    private final List<Graphic> children = new ArrayList<>();

    public CompositeGraphic(String name) {
        this.name = name;
    }

    public void add(Graphic graphic) {
        children.add(graphic);
    }

    public void remove(Graphic graphic) {
        children.remove(graphic);
    }

    @Override
    public void draw(String indent) {
        System.out.println(indent + "Composite: " + name);
        for (Graphic graphic : children) {
            graphic.draw(indent + "  ");
        }
    }
}
