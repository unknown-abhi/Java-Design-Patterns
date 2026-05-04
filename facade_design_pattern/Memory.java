/**
 * Subsystem class - Memory
 * Complex component that manages RAM and memory operations.
 */
public class Memory {
    // Load data into memory
    public void load(long position, byte[] data) {
        System.out.println("Memory: Loading " + data.length + " bytes at position " + position);
    }

    // Read from memory
    public byte[] read(long position, int size) {
        System.out.println("Memory: Reading " + size + " bytes from position " + position);
        return new byte[size];
    }
}
