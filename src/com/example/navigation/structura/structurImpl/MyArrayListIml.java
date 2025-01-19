package com.example.navigation.structura.structurImpl;

import com.example.navigation.structura.MyList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

public class MyArrayListIml<T> implements MyList<T>, Iterable<T> {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 16;

    public MyArrayListIml() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void add(T value) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
        elements[size++] = value;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) elements[index];
    }

    @Override
    public void remove(T value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elements[i], value)) {
                for (int j = i; j < size - 1; j++) {
                    elements[j] = elements[j + 1];
                }
                elements[--size] = null;
                return;
            }
        }
    }

    @Override
    public void sort(Comparator<T> comparator) {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                T current = (T) elements[j];
                T next = (T) elements[j + 1];
                if (comparator.compare(current, next) > 0) {

                    elements[j] = next;
                    elements[j + 1] = current;
                }
            }
        }

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elements[i], value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIteratorImpl<>(this, t -> true);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public T getStartPoint(){
        return size == 0 ? null : (T) elements[0];
    }

    @Override
    public T getEndPoint(){
        return size == 0 ? null : (T) elements[size -1];
    }
}

