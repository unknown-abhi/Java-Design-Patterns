/**
 * Demonstrates the Facade design pattern.
 * The Facade pattern provides a unified, simplified interface to a set of
 * complex subsystems.
 * Without the facade, the client would need to interact with CPU, Memory, and
 * HardDrive directly.
 * With the facade, the client only interacts with ComputerFacade.
 */
public class MainApp {
    public static void main(String[] args) {
        // Create facade - client doesn't see the complex subsystems
        ComputerFacade computer = new ComputerFacade();

        // Simple operation - hides complex subsystem interactions
        // Without facade, we would need to:
        // 1. Create CPU, Memory, HardDrive objects
        // 2. Call methods on each in the correct order
        // 3. Manage all the interactions
        computer.start();

        System.out.println("Computer is running...");

        // Another simple operation
        computer.stop();

        // Benefits of Facade Pattern:
        // 1. Simplifies complex subsystems with a simple interface
        // 2. Reduces coupling between client and subsystems
        // 3. Makes code easier to use and understand
        // 4. Provides a centralized entry point for subsystem operations
        // 5. Can control which subsystem methods are exposed to clients
    }
}
