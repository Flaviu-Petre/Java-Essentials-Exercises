package models;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Task implements Runnable{
    //region variables
    private static ConcurrentHashMap<String, Integer> taskData = new ConcurrentHashMap<>();
    private static final Random random = new Random();
    private static final AtomicInteger taskIdCounter = new AtomicInteger(0);
    private final int taskId;
    //endregion

    //region constructor
    public Task() {
        this.taskId = taskIdCounter.incrementAndGet();
    }
    //endregion

    //region getters and setters
    public void addTaskData(String key, Integer value) {
        taskData.put(key, value);
    }

    public Integer getTaskData(String key) {
        return taskData.getOrDefault(key, null);
    }

    public static int getSizeOfTaskData() {
        return taskData.size();
    }
    //endregion

    //region methods
    @Override
    public void run() {
        try{
            System.out.println("Task is being executed with data: " + taskData);

            String uniqueKey = "task-" + taskId + "-thread-" + Thread.currentThread().getName() +
                    "-" + System.currentTimeMillis() + "-" + random.nextInt(10000);

            Integer randomValue = random.nextInt(1000);

            taskData.put(uniqueKey, randomValue);

            System.out.println("Task " + taskId + " added: " + uniqueKey + " = " + randomValue);

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Task interrupted: " + e.getMessage());
        } finally {
            System.out.println("Task completed with data: " + taskData);
        }
    }
    //endregion
}
