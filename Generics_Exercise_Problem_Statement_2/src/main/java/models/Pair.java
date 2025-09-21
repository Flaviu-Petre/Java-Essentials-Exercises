package models;

public class Pair<T, E>{
    //region Variables
    private T _first;
    private E _second;
    //endregion

    //region Constructors
    public Pair(T _first, E _second) {
        this._first = _first;
        this._second = _second;
    }

    public Pair() {
        this._first = null;
        this._second = null;
    }
    //endregion

    //region getters
    public T get_first() {
        return _first;
    }

    public void set_first(T _first) {
        this._first = _first;
    }
    //endregion

    //region setters
    public E get_second() {
        return _second;
    }

    public void set_second(E _second) {
        this._second = _second;
    }
    //endregion

    //region methods
    public void swapElemnents(Pair<T, E> pairToSwap){
        T tempFirst = this._first;
        E tempSecond = this._second;

        this._first = (T) pairToSwap.get_first();
        this._second = (E) pairToSwap.get_second();

        pairToSwap.set_first(tempFirst);
        pairToSwap.set_second(tempSecond);
    }

    public void printPair() {
        System.out.println("First: " + _first + ", Second: " + _second);
    }
    //endregion

}
