package com.example.navigation.structura;

import java.util.Comparator;

public interface MyList<T> {
    void add(T value);
    T get(int index);
    void remove(T value);
    void sort(Comparator<T> comparator);
    int size();
    boolean contains(T value);
    T getStartPoint();
    T getEndPoint();
}
