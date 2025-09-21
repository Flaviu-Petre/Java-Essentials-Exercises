package models;

import java.util.Random;

public class Task implements  Runnable {
    private int _taskId;
    private static final Random _random = new Random();

    public Task(int taskId) {
        this._taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " is executing task " + _taskId);
        try {
            int sleepTime = _random.nextInt(5000) + 1000; // 1000-5999ms
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
    }
    }
}
