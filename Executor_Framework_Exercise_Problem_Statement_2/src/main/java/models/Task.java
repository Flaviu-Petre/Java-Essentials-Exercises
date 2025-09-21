package models;

import java.util.concurrent.Callable;

public class Task implements Callable<Integer> {
    private String _taskId;
    private int _number;

    public Task(String taskId, int _number) {
        this._taskId = taskId;
        this._number = _number;
    }

    @Override
    public Integer call() {
        System.out.println("Thread" + Thread.currentThread().getName() + " is executing task " + _taskId);
        try {
            Thread.sleep(1000); // Simulate task execution time
            int resultOfCallMethod = _number * (_number + 1) / 2;
            return resultOfCallMethod;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }


}
