import java.util.HashMap;
import java.util.Map;

/**
 * Flyweight Factory - manages flyweight objects and ensures sharing.
 * Creates flyweights only when needed, otherwise returns existing ones.
 * This is the key to memory efficiency in the Flyweight pattern.
 */
public class CharacterFactory {
    // Pool of flyweights - maps character symbols to flyweight instances
    private static final Map<java.lang.Character, ConcreteCharacter> characterPool = new HashMap<>();

    /**
     * Factory method to get a character flyweight.
     * Returns existing flyweight if available, creates new one otherwise.
     * 
     * @param symbol The character symbol to get a flyweight for
     * @return The flyweight instance for the given symbol
     */
    public static ConcreteCharacter getCharacter(char symbol) {
        // Check if we already have a flyweight for this symbol
        ConcreteCharacter character = characterPool.get(symbol);

        if (character == null) {
            // Create new flyweight and add to pool
            character = new ConcreteCharacter(symbol);
            characterPool.put(symbol, character);
        } else {
            // Reuse existing flyweight
            System.out.println("Reusing existing character flyweight for: '" + symbol + "'");
        }

        return character;
    }

    /**
     * Get the total number of flyweights created (pool size).
     * This shows how many unique flyweights are being shared.
     */
    public static int getPoolSize() {
        return characterPool.size();
    }
}