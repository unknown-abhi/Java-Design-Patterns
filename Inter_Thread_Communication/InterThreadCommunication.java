package Inter_Thread_Communication;

// Main class to demonstrate inter-thread communication using wait() and notify()
public class InterThreadCommunication {
    public static void main(String[] args) {
        // Create a thread object (SumDemo is assumed to be a Thread subclass)
        SumDemo th = new SumDemo();
        th.start(); // Start the thread, which will calculate the sum in the background

        // Synchronize on the thread object to safely call wait()
        synchronized (th) { // Lock on 'th' object
            try {
                th.wait(); // Main thread waits until notified by 'th'
                // th.join(); // (Alternative: Wait for thread to finish, but doesn't use
                // notify/wait)
                System.out.println("Sum : " + th.getSum()); // Print the result after being notified
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

/*
 * Example Explanation:
 * Suppose SumDemo calculates the sum of numbers from 1 to 100.
 * - The main thread starts SumDemo and then waits for it to finish calculation
 * using wait().
 * - Inside SumDemo, after calculation, notify() is called to wake up the main
 * thread.
 * - The main thread resumes and prints the sum.
 * 
 * Key Concepts:
 * - wait(): Causes the current thread to wait until another thread calls
 * notify() or notifyAll() on the same object.
 * - notify(): Wakes up a single thread that is waiting on the object's monitor.
 * - Synchronization is required to call wait()/notify() on an object.
 */
