package models;

public class Counter{
    //region variables
    private int _counter;
    //endregion

    //region constructor
    public Counter() {
        this._counter = 0;
    }

    public Counter(int counter, String threadName) {
        this._counter = 0;
        Thread.currentThread().setName(threadName);
    }
    //endregion

    //region getters and setters
    public synchronized int getCounter() {
        return _counter;
    }

    public void setCounter(int counter) {
        this._counter = counter;
    }
    //endregion

    //region methods

    public synchronized void increment() {
        this._counter++;
    }

    //endregion

}
