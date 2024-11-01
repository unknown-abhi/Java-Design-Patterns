package deadlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockWithTimeoutExample {
    public static void main(String[] args) {
        final Lock lock1 = new ReentrantLock();
        final Lock lock2 = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            try {
                // Try to acquire lock1 with a timeout
                if (lock1.tryLock(100, TimeUnit.MILLISECONDS)) {
                    try {
                        System.out.println("Thread 1: Acquired lock1");

                        // Simulate work
                        Thread.sleep(50);

                        // Try to acquire lock2 with a timeout
                        if (lock2.tryLock(100, TimeUnit.MILLISECONDS)) {
                            try {
                                System.out.println("Thread 1: Acquired lock2");
                                // Perform actions
                            } finally {
                                lock2.unlock();
                            }
                        } else {
                            System.out.println("Thread 1: Could not acquire lock2");
                        }
                    } finally {
                        lock1.unlock();
                    }
                } else {
                    System.out.println("Thread 1: Could not acquire lock1");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                // Try to acquire lock2 with a timeout
                if (lock2.tryLock(100, TimeUnit.MILLISECONDS)) {
                    try {
                        System.out.println("Thread 2: Acquired lock2");

                        // Simulate work
                        Thread.sleep(50);

                        // Try to acquire lock1 with a timeout
                        if (lock1.tryLock(100, TimeUnit.MILLISECONDS)) {
                            try {
                                System.out.println("Thread 2: Acquired lock1");
                                // Perform actions
                            } finally {
                                lock1.unlock();
                            }
                        } else {
                            System.out.println("Thread 2: Could not acquire lock1");
                        }
                    } finally {
                        lock2.unlock();
                    }
                } else {
                    System.out.println("Thread 2: Could not acquire lock2");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }
}