/**
 * Subsystem class - HardDrive
 * Complex component that handles disk read/write operations.
 */
public class HardDrive {
    // Read data from disk
    public byte[] read(long lba, int size) {
        System.out.println("HardDrive: Reading " + size + " bytes from sector " + lba);
        return new byte[size];
    }

    // Write data to disk
    public void write(long lba, byte[] data) {
        System.out.println("HardDrive: Writing " + data.length + " bytes to sector " + lba);
    }
}
