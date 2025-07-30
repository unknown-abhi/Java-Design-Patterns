package Inter_Thread_Communication;

// SumDemo class extends Thread and calculates the sum of numbers from 0 to 10.
// It demonstrates inter-thread communication using wait() and notify().
public class SumDemo extends Thread {
    private int sum = 0; // Variable to store the sum

    // This method is executed when the thread starts
    public void run() {
        // Synchronize on this object so we can safely call notify()
        synchronized (this) {
            this.sum = 0; // Initialize sum
            for (int i = 0; i <= 10; i++) {
                this.sum += i; // Calculate sum from 0 to 10
            }
            // Notify any thread waiting on this object (main thread in this case)
            this.notify();
        }
    }

    // Method to get the calculated sum
    public int getSum() {
        return this.sum;
    }
}

/*
 * Example Usage:
 * ---------------
 * - The main thread creates and starts a SumDemo thread.
 * - The main thread then waits (using wait()) for the SumDemo thread to finish
 * calculation.
 * - After calculation, SumDemo calls notify() to wake up the main thread.
 * - The main thread resumes and prints the sum.
 * 
 * Output:
 * Sum : 55
 * 
 * Key Concepts:
 * - notify(): Wakes up a thread waiting on this object's monitor (here, the
 * main thread).
 * - synchronized (this): Ensures that notify() is called while holding the
 * object's lock.
 */
