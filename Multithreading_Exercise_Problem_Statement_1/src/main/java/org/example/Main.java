package org.example;

import models.Counter;
import models.CounterTask;

public class Main {
    public static void main(String[] args) {

        Counter sharedCounter = new Counter();

        System.out.println("Starting threads...");
        Thread thread1 = new Thread(new CounterTask(sharedCounter, "Thread-1"));
        Thread thread2 = new Thread(new CounterTask(sharedCounter, "Thread-2"));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread1.sleep(200);
            thread2.join();
            System.out.println("Both threads completed.");
            System.out.println("Final count: " + sharedCounter.getCounter());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}