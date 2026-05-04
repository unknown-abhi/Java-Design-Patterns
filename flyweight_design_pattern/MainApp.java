/**
 * Main application demonstrating the Flyweight Design Pattern.
 * The Flyweight pattern is used when we need to create a large number of
 * similar objects.
 * It reduces memory usage by sharing common parts of state among multiple
 * objects.
 *
 * In this example:
 * - Intrinsic state: the character symbol (shared)
 * - Extrinsic state: position coordinates (unique per usage)
 *
 * Without flyweight: Each character instance would store its own symbol
 * With flyweight: Only unique symbols are stored, positions are passed as
 * parameters
 */
public class MainApp {
    public static void main(String[] args) {
        System.out.println("=== Flyweight Design Pattern Demo ===\n");

        // Text to render: "HELLO"
        String text = "HELLO";
        int[][] positions = {
                { 0, 0 }, { 1, 0 }, { 2, 0 }, { 3, 0 }, { 4, 0 } // H E L L O
        };

        System.out.println("Rendering text: " + text);
        System.out.println("Each character will be drawn at different positions\n");

        // Render each character
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            int[] pos = positions[i];

            // Get flyweight for this character (shared intrinsic state)
            ConcreteCharacter character = CharacterFactory.getCharacter(symbol);

            // Draw with extrinsic state (position)
            character.draw(pos[0], pos[1]);
        }

        System.out.println("\n=== Pattern Benefits ===");
        System.out.println("Total characters rendered: " + text.length());
        System.out.println("Unique flyweights created: " + CharacterFactory.getPoolSize());
        System.out.println("Memory saved by sharing flyweights!");

        System.out.println("\n=== Rendering the same text again ===");
        // Render the same text again to show flyweight reuse
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            int[] pos = positions[i];

            ConcreteCharacter character = CharacterFactory.getCharacter(symbol);
            character.draw(pos[0], pos[1]);
        }

        System.out.println("\nNotice how flyweights are reused for repeated characters!");
    }
}