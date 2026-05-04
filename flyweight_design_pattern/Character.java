/**
 * Flyweight interface - defines the interface for flyweight objects.
 * Flyweights have intrinsic state (shared) and accept extrinsic state (unique).
 * The draw method takes extrinsic state (position) as parameters.
 */
public interface Character {
    // Draw method accepts extrinsic state (position coordinates)
    void draw(int x, int y);
}