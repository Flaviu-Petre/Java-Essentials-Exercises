package org.example;

import models.Task;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<Integer> taskFuture;

        for(int i = 0; i < 100; i++){
            Task task = new Task("Task-" + i, i);

            taskFuture = executorService.submit(task);

            System.out.println(taskFuture.get());
        }

        executorService.shutdown();
    }
}