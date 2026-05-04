/**
 * Facade class that provides a simplified interface to the complex subsystem.
 * Hides the complexity of CPU, Memory, and HardDrive interactions.
 * Clients only need to interact with this facade instead of multiple subsystem
 * classes.
 */
public class ComputerFacade {
    // Subsystem components
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    // Constructor initializes the subsystem components
    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    /**
     * Simple start method that hides complex subsystem interactions.
     * Client doesn't need to know about CPU, Memory, and HardDrive details.
     */
    public void start() {
        System.out.println("\n--- Starting Computer ---");
        // Step 1: Read boot program from disk
        byte[] bootProgram = hardDrive.read(0, 1024);
        // Step 2: Load boot program into memory
        memory.load(0, bootProgram);
        // Step 3: CPU jumps to boot address
        cpu.jump(0);
        // Step 4: CPU executes the boot program
        cpu.load();
        cpu.execute();
        System.out.println("Computer started successfully!\n");
    }

    /**
     * Simple stop method that hides complex shutdown process.
     */
    public void stop() {
        System.out.println("\n--- Stopping Computer ---");
        System.out.println("Computer: Shutting down all components...");
        System.out.println("CPU: Halted");
        System.out.println("Memory: Cleared");
        System.out.println("HardDrive: Stopped");
        System.out.println("Computer stopped successfully!\n");
    }
}
