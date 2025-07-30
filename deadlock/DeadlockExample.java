package deadlock;

public class DeadlockExample {
    public static void main(String[] args) {
        final String resource1 = "Resource1"; // First shared resource
        final String resource2 = "Resource2"; // Second shared resource

        // Thread 1 tries to lock resource1 then resource2
        Thread t1 = new Thread(() -> {
            synchronized (resource1) { // Lock resource1
                System.out.println("Thread 1: Locked resource 1");

                try {
                    Thread.sleep(100); // Pause to increase chance of deadlock
                } catch (Exception e) {
                }

                synchronized (resource2) { // Try to lock resource2
                    System.out.println("Thread 1: Locked resource 2");
                }
            }
        });

        // Thread 2 tries to lock resource2 then resource1 (opposite order)
        Thread t2 = new Thread(() -> {
            synchronized (resource2) { // Lock resource2
                System.out.println("Thread 2: Locked resource 2");

                try {
                    Thread.sleep(100); // Pause to increase chance of deadlock
                } catch (Exception e) {
                }

                synchronized (resource1) { // Try to lock resource1
                    System.out.println("Thread 2: Locked resource 1");
                }
            }
        });

        t1.start(); // Start Thread 1
        t2.start(); // Start Thread 2
    }
}

/*
 * Example Explanation:
 * --------------------
 * - Thread 1 locks resource1, then tries to lock resource2.
 * - Thread 2 locks resource2, then tries to lock resource1.
 * - If Thread 1 holds resource1 and waits for resource2, while Thread 2 holds
 * resource2 and waits for resource1,
 * both threads wait forever. This is a classic deadlock situation.
 * 
 * Output Example (may vary):
 * Thread 1: Locked resource 1
 * Thread 2: Locked resource 2
 * // Both threads now wait forever, causing a deadlock.
 * 
 * Key Concepts:
 * -------------
 * - Deadlock occurs when two or more threads are blocked forever, each waiting
 * for the other to release a lock.
 * - To avoid deadlock, always acquire locks in the same order in every thread.
 */
