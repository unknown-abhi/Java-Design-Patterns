package Callable_And_Future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableAndFutureDemo {
    public static void main(String[] args) {
        // Create a Callable task
        ExecutorService executor = Executors.newCachedThreadPool();

        Callable<String> callable = () -> {

            Thread.sleep(5000);
            return "Result return from :: " + Thread.currentThread().getName();
        };

        // Submit the Callable task to the ExecutorService
        Future<String> future = executor.submit(callable);

        // Perform other tasks while callable is getting executed in parallel
        System.out.println("Processing something else while callable is getting executed in parallel");

        // Retrieve the result from the Future object
        try {
            System.out.println("Result from Callable: " + future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Shut down the ExecutorService
        executor.shutdown();

        // Check if ExecutorService is terminated
        while (!executor.isTerminated()) {
            // Wait for a while before checking again
            try {
                System.out.println("ExecutorService waiting to terminated");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("ExecutorService is terminated");

    }

}
