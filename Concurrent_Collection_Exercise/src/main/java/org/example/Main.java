package org.example;

import models.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for(int i = 0; i < 100; i++){
            Task task = new Task();
            executorService.submit(task);
        }

        executorService.shutdown();

        // Wait for all tasks to finish
        if (executorService.awaitTermination(2, TimeUnit.MINUTES)) {
            System.out.println("All tasks completed successfully");
        } else {
            System.out.println("Timeout occurred - forcing shutdown");
            executorService.shutdownNow();
        }

        System.out.println("The size of the task data is: " + Task.getSizeOfTaskData());
    }
}