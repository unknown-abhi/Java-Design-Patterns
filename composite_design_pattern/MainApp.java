/**
 * Demonstrates the Composite pattern by nesting graphics in a tree structure.
 */
public class MainApp {
    public static void main(String[] args) {
        CompositeGraphic allGraphics = new CompositeGraphic("All Graphics");

        CompositeGraphic group1 = new CompositeGraphic("Group 1");
        group1.add(new Ellipse("Ellipse A"));
        group1.add(new Ellipse("Ellipse B"));

        CompositeGraphic group2 = new CompositeGraphic("Group 2");
        group2.add(new Ellipse("Ellipse C"));
        group2.add(new Ellipse("Ellipse D"));

        allGraphics.add(group1);
        allGraphics.add(group2);
        allGraphics.add(new Ellipse("Ellipse E"));

        allGraphics.draw("");
    }
}
