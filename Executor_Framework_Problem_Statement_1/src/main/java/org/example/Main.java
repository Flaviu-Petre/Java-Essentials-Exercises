package org.example;

import models.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for(int i = 0; i < 20; i++ ){
            int taskId = i + 1;

            Task task = new Task(taskId);

            executorService.submit(task);
        }

        executorService.shutdown();

        if (executorService.awaitTermination(10, TimeUnit.SECONDS)) {
            System.out.println("All tasks finished");
        } else {
            System.out.println("Timeout occurred before all tasks finished");
            executorService.shutdownNow();
        }

    }
}