package models;

public class CounterTask implements Runnable {
    private final Counter _counter;
    private final String _threadName;

    public CounterTask(Counter counter, String threadName) {
        this._counter = counter;
        this._threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println(_threadName + " started.");
        for (int i = 0; i <= 999; i++) {
            _counter.increment();
        }
        synchronized (_counter) {
            System.out.println(_threadName + " finished. Current count: " + _counter.getCounter());
        }
    }
}
