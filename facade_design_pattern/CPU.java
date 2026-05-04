/**
 * Subsystem class - CPU
 * Complex component that handles processor operations.
 */
public class CPU {
    // Load data into the CPU
    public void load() {
        System.out.println("CPU: Loading data...");
    }

    // Execute operations
    public void execute() {
        System.out.println("CPU: Executing operations...");
    }

    // Jump to memory address
    public void jump(long position) {
        System.out.println("CPU: Jumping to position " + position);
    }
}
