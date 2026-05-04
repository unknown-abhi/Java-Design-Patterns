/**
 * Concrete Flyweight - represents a character with intrinsic state.
 * The intrinsic state (character symbol) is shared among multiple instances.
 * Extrinsic state (position) is passed in via the draw method.
 */
public class ConcreteCharacter implements Character {
    // Intrinsic state - shared among all instances of the same character
    private final char symbol;

    // Constructor takes the intrinsic state
    public ConcreteCharacter(char symbol) {
        this.symbol = symbol;
        System.out.println("Creating character flyweight for: '" + symbol + "'");
    }

    @Override
    public void draw(int x, int y) {
        // Extrinsic state is passed in - position coordinates
        System.out.println("Drawing '" + symbol + "' at position (" + x + ", " + y + ")");
    }

    // Getter for intrinsic state (useful for factory management)
    public char getSymbol() {
        return symbol;
    }
}