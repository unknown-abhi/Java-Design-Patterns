package deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This example demonstrates how to avoid deadlocks using tryLock() with two
 * locks.
 * 
 * Scenario:
 * - There are two locks: lock1 and lock2.
 * - Two threads (t1 and t2) try to acquire both locks, but in different orders.
 * - Thread 1 tries to acquire lock1 first, then lock2.
 * - Thread 2 tries to acquire lock2 first, then lock1.
 * - Using tryLock() prevents deadlock because if a thread can't acquire the
 * second lock,
 * it releases the first lock and doesn't wait forever.
 * 
 * Example Output:
 * Thread 1: Acquired lock1
 * Thread 1: Could not acquire lock2
 * Thread 2: Acquired lock2
 * Thread 2: Acquired lock1
 */
public class TryLockExample {
    public static void main(String[] args) {
        // Create two reentrant locks
        final Lock lock1 = new ReentrantLock();
        final Lock lock2 = new ReentrantLock();

        // Thread 1 tries to acquire lock1, then lock2
        Thread t1 = new Thread(() -> {
            try {
                // Try to acquire lock1 without waiting
                if (lock1.tryLock()) {
                    try {
                        System.out.println("Thread 1: Acquired lock1");

                        // Simulate some work with lock1 held
                        Thread.sleep(50);

                        // Try to acquire lock2 without waiting
                        if (lock2.tryLock()) {
                            try {
                                System.out.println("Thread 1: Acquired lock2");
                                // Both locks acquired, perform actions here
                            } finally {
                                // Always release lock2 if acquired
                                lock2.unlock();
                            }
                        } else {
                            // Could not acquire lock2, avoid deadlock by not waiting
                            System.out.println("Thread 1: Could not acquire lock2");
                        }
                    } finally {
                        // Always release lock1 if acquired
                        lock1.unlock();
                    }
                } else {
                    // Could not acquire lock1
                    System.out.println("Thread 1: Could not acquire lock1");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Thread 2 tries to acquire lock2, then lock1 (opposite order)
        Thread t2 = new Thread(() -> {
            try {
                // Try to acquire lock2 without waiting
                if (lock2.tryLock()) {
                    try {
                        System.out.println("Thread 2: Acquired lock2");

                        // Simulate some work with lock2 held
                        Thread.sleep(50);

                        // Try to acquire lock1 without waiting
                        if (lock1.tryLock()) {
                            try {
                                System.out.println("Thread 2: Acquired lock1");
                                // Both locks acquired, perform actions here
                            } finally {
                                // Always release lock1 if acquired
                                lock1.unlock();
                            }
                        } else {
                            // Could not acquire lock1, avoid deadlock by not waiting
                            System.out.println("Thread 2: Could not acquire lock1");
                        }
                    } finally {
                        // Always release lock2 if acquired
                        lock2.unlock();
                    }
                } else {
                    // Could not acquire lock2
                    System.out.println("Thread 2: Could not acquire lock2");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start both threads
        t1.start();
        t2.start();
    }
}