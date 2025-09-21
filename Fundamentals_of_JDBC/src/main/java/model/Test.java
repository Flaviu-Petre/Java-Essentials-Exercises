package model;

public class Test<T extends Number & Comparable<T>> {
    T obj;

    Test(T obj) { this.obj = obj; }

    double square() { return obj.doubleValue() * obj.doubleValue(); }
}
