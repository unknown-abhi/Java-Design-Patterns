package Reentrant_Lock;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

/**
 * Demonstrates various features of ReentrantLock in Java:
 * 1. Reentrancy (a thread can acquire the same lock multiple times)
 * 2. Explicit locking/unlocking (unlike 'synchronized', you must unlock manually)
 * 3. Non-blocking and timed lock attempts (tryLock)
 * 4. Interruptible lock acquisition (lockInterruptibly)
 */
public class ReentrantLockExample {
    // Create a fair lock (FIFO order). If set to 'false', lock is unfair (default).
    private final ReentrantLock lock = new ReentrantLock(true);

    private int counter = 0; // shared resource protected by the lock

    // ---------------------------
    // 1️⃣ Reentrancy Demo
    // ---------------------------
    /**
     * Demonstrates reentrancy: a thread holding the lock can reacquire it.
     * Calls another method (nestedMethod) that also locks the same lock.
     */
    public void reentrantMethod() {
        lock.lock(); // Thread acquires lock (lock count = 1)
        try {
            System.out.println(Thread.currentThread().getName() + " got lock in reentrantMethod");
            nestedMethod(); // Call another method that also needs same lock
        } finally {
            lock.unlock(); // Release lock (lock count = 0)
        }
    }

    /**
     * Called from reentrantMethod. Same thread locks again (lock count = 2).
     * Demonstrates that ReentrantLock allows the same thread to lock multiple times.
     */
    private void nestedMethod() {
        lock.lock(); // Same thread can lock again (reentrant, lock count = 2)
        try {
            System.out.println(Thread.currentThread().getName() + " got lock again in nestedMethod");
        } finally {
            lock.unlock(); // Must unlock again (lock count = 1)
        }
    }

    // ---------------------------
    // 2️⃣ Explicit Locking
    // ---------------------------
    /**
     * Shows explicit locking and unlocking.
     * Unlike 'synchronized', you must always unlock in a finally block.
     */
    public void explicitLocking() {
        lock.lock(); // Thread tries to get lock
        try {
            counter++; // Critical section: only one thread can increment at a time
            System.out.println(Thread.currentThread().getName() + " increased counter to " + counter);
        } finally {
            lock.unlock(); // Must release lock manually (unlike synchronized)
        }
    }

    // ---------------------------
    // 3️⃣ Try Locking (non-blocking & timeout)
    // ---------------------------
    /**
     * Demonstrates non-blocking and timed attempts to acquire the lock.
     * - tryLock(): returns immediately, true if lock acquired, false otherwise.
     * - tryLock(timeout): waits up to timeout for the lock.
     */
    public void tryLocking() {
        // Try to get lock immediately (does not wait)
        if (lock.tryLock()) {
            try {
                System.out.println(Thread.currentThread().getName() + " got lock using tryLock()");
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + " could NOT get lock using tryLock()");
        }

        // Try to get lock, but wait up to 1 second
        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                try {
                    System.out.println(Thread.currentThread().getName() + " got lock using tryLock(timeout)");
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " waited 1 sec but still no lock");
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted while waiting in tryLock(timeout)");
        }
    }

    // ---------------------------
    // 4️⃣ Interruptible Lock Acquisition
    // ---------------------------
    /**
     * Demonstrates lock acquisition that can be interrupted.
     * If the thread is interrupted while waiting for the lock, it throws InterruptedException.
     */
    public void interruptibleLocking() {
        try {
            System.out.println(Thread.currentThread().getName() + " trying lockInterruptibly...");
            lock.lockInterruptibly(); // Thread can be interrupted while waiting
            try {
                System.out.println(Thread.currentThread().getName() + " got lock using lockInterruptibly()");
                Thread.sleep(2000); // Hold lock for 2 sec to simulate long work
            } finally {
                lock.unlock(); // Release lock
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted before getting the lock");
        }
    }

    /**
     * Main method to demonstrate all features.
     * Starts threads for each demo. Thread-D is interrupted after 1 second to show interruptible locking.
     */
    public static void main(String[] args) throws InterruptedException {
        ReentrantLockExample demo = new ReentrantLockExample();

        // 1️⃣ Reentrancy demo: Thread-A will call reentrantMethod (which calls nestedMethod)
        new Thread(demo::reentrantMethod, "Thread-A").start();

        // 2️⃣ Explicit locking demo: Thread-B will increment counter
        new Thread(demo::explicitLocking, "Thread-B").start();

        // 3️⃣ Try locking demo: Thread-C will attempt to acquire lock non-blocking and with timeout
        new Thread(demo::tryLocking, "Thread-C").start();

        // // 4️⃣ Interruptible lock acquisition demo: Thread-D will try to acquire lockInterruptibly
        Thread t = new Thread(demo::interruptibleLocking, "Thread-D");
        t.start();

        // // After 1 sec, interrupt Thread-D to show lockInterruptibly() can be cancelled
        Thread.sleep(1000);
        t.interrupt();
    }
}

